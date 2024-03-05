package coml.amen.amazonecommerce

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    companion object {
        val registeredUsers = mutableListOf<User>()
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setBackgroundColor(Color.parseColor("#FFBF00"))
        val email = findViewById<EditText>(R.id.email).text.toString()
       val password = findViewById<EditText>(R.id.password).text.toString()

        button.setOnClickListener {
            if(validateCredentials(email, password)){
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }
            else{
                Toast.makeText(this,"Invalid Credentials", Toast.LENGTH_LONG).show()
            }


    }
        val createAccount = findViewById<Button>(R.id.button2);
        createAccount.setOnClickListener{
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }
    }

    private  fun validateCredentials(email:String, password:String):Boolean{
        return registeredUsers.any{it.email == email && it.password == password}
    }
}