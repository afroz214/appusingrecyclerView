package com.smartherd.appusingrecyclerview

import android.app.Dialog
import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class Adapter(data:ArrayList<Custom_class>, var context:Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var data: List<Custom_class>

    init {
        this.data = data
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var image: ImageView
        var card: CardView
        lateinit var text2speech:TextToSpeech

        init {
            name = itemView.findViewById(R.id.item_text)
            image = itemView.findViewById(R.id.item_image)
            card = itemView.findViewById(R.id.card)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.custom_items, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = data[position].name
        holder.image.setImageResource(data[position].image)

        holder.card.setOnClickListener {

            val alert = Dialog(context)
            alert.setContentView(R.layout.alert)
            alert.window?.setType(WindowManager.LayoutParams.TYPE_TOAST)

            val name = alert.findViewById<TextView>(R.id.alert_text)
            val image = alert.findViewById<ImageView>(R.id.alert_circle)
            val spell = alert.findViewById<Button>(R.id.alert_spell)
            val done = alert.findViewById<Button>(R.id.alert_done)

            name.text = data[position].name
            image.setImageResource(data[position].image)

            alert.show()

            spell.setOnClickListener {

                holder.text2speech = TextToSpeech(context,TextToSpeech.OnInitListener { status ->

                    if (status == TextToSpeech.SUCCESS){
                        holder.text2speech.language = Locale.US
                        holder.text2speech.speak(data[position].name, TextToSpeech.QUEUE_FLUSH, null, null)
                    }
                })
            }

            done.setOnClickListener {
                alert.dismiss()
            }
        }
    }
}