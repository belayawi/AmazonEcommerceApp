package coml.amen.amazonecommerce

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CreateAccount : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val username = findViewById<EditText>(R.id.username).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()
        val email = findViewById<EditText>(R.id.email).text.toString()

        val button: Button = findViewById(R.id.button3)
        button.setOnClickListener{
            if(MainActivity.registeredUsers.any{it.email== email}){
                Toast.makeText(this,"Username already exists", Toast.LENGTH_LONG).show()
            }
            else{
                MainActivity.registeredUsers.add(User(username, password, email))
                Toast.makeText(this, "Account created Successfully ", Toast.LENGTH_LONG).show()
                val intent = Intent(this, ShoppingCategory::class.java)
                startActivity(intent)
            }


        }
    }
}