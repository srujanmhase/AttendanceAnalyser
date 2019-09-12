package io.github.srujanmhase.attendyx

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun secureInit(view: View){
        //Get all the views, get the values from the views as strings, convert strings to integers
        val siattoV = findViewById<EditText>(R.id.atto_in) //VIEW: FIRST INPUT 'ATTENDED'
        val siattoT = siattoV.text.toString() //STRING VALUE
        var siatto: Int = Integer.parseInt(siattoT) //INT VALUE

        val sitotoV = findViewById<EditText>(R.id.tot_in) //VIEW: SECOND INPUT 'TOTAL CONDUCTED'
        val sitotoT = sitotoV.text.toString() //STRING VALUE
        var sitoto: Int = Integer.parseInt(sitotoT) //INT VALUE

        val sitgtV = findViewById<EditText>(R.id.tgt_in) //VIEW: SECOND INPUT 'TOTAL CONDUCTED'
        val sitgtT = sitgtV.text.toString() //STRING VALUE
        var sitgt: Int = Integer.parseInt(sitgtT) //INT VALUE

        var sitext_one = findViewById<TextView>(R.id.textOne)

        if (siatto in 1..9999 && sitoto in 1..9999 && sitgt in 10..99 && siatto < sitoto){
            think(view)
        }
        else{
            sitext_one.text = getString(R.string.invalid_ip)
        }


    }
    fun think(view: View){
        //Get all the views, get the values from the views as strings, convert strings to integers
        val attoV = findViewById<EditText>(R.id.atto_in) //VIEW: FIRST INPUT 'ATTENDED'
        val attoT = attoV.text.toString() //STRING VALUE
        var atto: Float = attoT.toFloat() //INT VALUE

        val totoV = findViewById<EditText>(R.id.tot_in) //VIEW: SECOND INPUT 'TOTAL CONDUCTED'
        val totoT = totoV.text.toString() //STRING VALUE
        var toto: Float = totoT.toFloat() //INT VALUE

        val tgtV = findViewById<EditText>(R.id.tgt_in) //VIEW: SECOND INPUT 'TOTAL CONDUCTED'
        val tgtT = tgtV.text.toString() //STRING VALUE
        var tgt: Float = tgtT.toFloat() //DOUBLE VALUE

        var cper: Float = atto/toto

        var tgtP: Float = tgt
        var tgtR: Int = tgtP.toInt()
        var tgtQ: String = tgtR.toString()

        tgt/=100

        var textoneV = findViewById<TextView>(R.id.textOne) //VIEW: RESULT ONE
        var texttwoV = findViewById<TextView>(R.id.textTwo) //VIEW: RESULT TWO

        var bthese: Float
        var attoW: Float = atto
        var totoW: Float = toto
        var much: Float

        if (cper > tgt){
            textoneV.text = getString(R.string.dynamoOne, tgtQ)

            while(cper > tgt){
                totoW++
                cper = (atto/totoW)
            }
            bthese = totoW-toto

            var btheseP: Float = bthese
            var btheseR: Int = btheseP.toInt()
            var btheseQ: String = btheseR.toString()

            texttwoV.text = getString(R.string.dynamoTwo, btheseQ)

        }else if(cper == tgt){
            textoneV.text = getString(R.string.equal)
            texttwoV.text = getString(R.string.def_txt)

        }else if(cper < tgt){
            while (cper <= tgt){
                totoW++
                attoW++
                cper = (attoW/totoW)
            }
            much = (totoW - toto)
            var muchQ: Int = much.toInt()
            var muchS: String = muchQ.toString()

            textoneV.text = getString(R.string.lowo, muchS)
            texttwoV.text = getString(R.string.lowt)
        }
    }
}
