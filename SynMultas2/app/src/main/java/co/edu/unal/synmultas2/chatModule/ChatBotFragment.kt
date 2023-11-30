package co.edu.unal.synmultas2.chatModule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import co.edu.unal.synmultas2.R
import co.edu.unal.synmultas2.databinding.FragmentChatBotBinding
import co.edu.unal.synmultas2.mainModule.MainActivity

class ChatBotFragment : Fragment() {
    private lateinit var mBinding: FragmentChatBotBinding
    private lateinit var webView:  WebView
    private var mActivity: MainActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentChatBotBinding.inflate(inflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView=mBinding.webView
        webView.webChromeClient = MyWebChromeClient()
        webView.webViewClient = MyWebViewClient()

        webView.addJavascriptInterface( JS(view.context),"JS")
        val url = "https://web-chat.global.assistant.watson.appdomain.cloud/preview.html?integrationID=957f95fc-cec4-44f0-a74e-4549c003a328&region=us-south&serviceInstanceID=fd6e1e7e-3e6e-4f11-ae9c-725cc8e1c3ab"
        webView.loadUrl(url)
        setupActionBar()
    }

    override fun onDestroy() {
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mActivity?.supportActionBar?.title = getString(R.string.app_name)
        mActivity?.hideFab(true)
        setHasOptionsMenu(false)
        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                mActivity?.onBackPressedDispatcher?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupActionBar(){
        mActivity = activity as? MainActivity
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mActivity?.supportActionBar?.title = getString(R.string.chat_bot_title)
    }

    private inner class MyWebViewClient : WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            val script = ""
            webView.evaluateJavascript(script,null)
            super.onPageFinished(view, url)
        }
    }

    private inner class MyWebChromeClient : WebChromeClient() {
        // Puedes agregar métodos adicionales de WebChromeClient según tus necesidades
    }
}
