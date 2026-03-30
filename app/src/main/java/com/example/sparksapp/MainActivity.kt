package com.example.sparksapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

// This is the main screen of the app
class MainActivity : AppCompatActivity() {

    // This section declares the UI components
    private lateinit var inputTime: EditText
    private lateinit var resultText: TextView
    private lateinit var suggestButton: Button
    private lateinit var resetButton: Button

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This links the activity to the XML layout
        setContentView(R.layout.activity_main)

        // This section connects Kotlin variables to UI elements in XML
        inputTime = findViewById(R.id.inputTime)
        resultText = findViewById(R.id.resultText)
        suggestButton = findViewById(R.id.suggestButton)
        resetButton = findViewById(R.id.resetButton)

        // This button is for when "get suggestion" is clicked
        suggestButton.setOnClickListener {

            // This section gets the user to input, remove spaces and convert to lowercase
            val time = inputTime.text.toString().trim().lowercase()

            // Checks if the input section is empty
            if (time.isEmpty()) {
                resultText.text = " Hello! please enter a time of day. "
                return@setOnClickListener // Stop further execution
            }

            // Determines a suggestion using when, similar to if-else
            val suggestion = when (time) {

                // This section provides a morning message suggestion
                "morning" -> "Send a 'Good morning' text to a family member ☀️"

                // Provides a mid-morning message suggestion with two formats
                "mid-morning", "mid morning" ->
                    "Reach out to a colleague with a quick 'Thank you' 🙌"

                // Provides an afternoon message suggestion
                "afternoon" ->
                    "Share a funny meme or interesting link with a friend 😂"

                // Provides a snack time suggestion
                "snack", "afternoon snack time" ->
                    "Send a quick 'Thinking of you' message 💬"

                // Provides a dinner suggestion
                "dinner" ->
                    "Call a friend or relative for a 5-minute catch-up 📞"

                // Provides a night/after dinner suggestion
                "night", "after dinner" ->
                    "Leave a thoughtful comment on a friend's post 🌙"

                // This will appear if there's no input that's recognized
                else ->
                    "Hmm… I don’t recognize that time. Try Morning, Afternoon, Dinner, or Night 👍"
            }

            // Displays suggestion on screen
            resultText.text = suggestion
        }

        // This is for when the "reset" button is clicked
        resetButton.setOnClickListener {

            // Clears the input field
            inputTime.text.clear()

            // clears the result text
            resultText.text = ""
        }
    }
}