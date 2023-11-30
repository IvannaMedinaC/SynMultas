package co.edu.unal.synmultas2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import co.edu.unal.synmultas2.databinding.ActivityStartBinding
import co.edu.unal.synmultas2.mainModule.MainActivity
import com.google.android.material.textfield.TextInputLayout

class StartActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        with(mBinding) {
            eTextPlate.addTextChangedListener { validateFields(tilPlate) }
            button.setOnClickListener { launchMainActivity() }
            root.setOnClickListener { hideKeyBoard() }
        }
    }

    private fun launchMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        val plate = mBinding.eTextPlate.text.toString().trim()
        if(plate.length==6) {
            intent.putExtra("plate",plate)
            startActivity(intent)
        }else{
            mBinding.tilPlate.error = getString(R.string.invalid_plate)
            Toast.makeText(this,getString(R.string.invalid_plate),Toast.LENGTH_SHORT).show()
        }
    }

    private fun hideKeyBoard(){
        val view: View = currentFocus ?: View(this)
        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun validateFields(vararg textFields: TextInputLayout): Boolean {
        var isValid = true
        for(textField in textFields){
            if(textField.editText?.text.toString().trim().isEmpty()) {
                textField.error = getString(R.string.invalid_plate)
                isValid = false
            }else {
                textField.error = null
            }
        }
        return isValid
    }

    override fun onDestroy() {
        super.onDestroy()
        hideKeyBoard()
    }
}