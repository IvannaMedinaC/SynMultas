package co.edu.unal.synmultas2.chatModule

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class JS (context : Context) {
    private val ctx: Context =context

    @JavascriptInterface
    fun getlink( link : String ){
        Toast.makeText(ctx,""+link,Toast.LENGTH_SHORT).show()
    }
}