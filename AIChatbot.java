import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AIChatbot extends JFrame {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    AIChatbot() {

        setTitle("AI Chatbot");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        inputField = new JTextField();
        sendButton = new JButton("Send");

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        chatArea.append("Bot: Hello! I am your AI Chatbot.\n");
        chatArea.append("Bot: You can ask me about Java, AI, college or general questions.\n\n");

        sendButton.addActionListener(e -> sendMessage());

        inputField.addActionListener(e -> sendMessage());

        setVisible(true);
    }

    void sendMessage() {

        String userMessage = inputField.getText().trim();

        if (userMessage.isEmpty()) {
            return;
        }

        chatArea.append("You: " + userMessage + "\n");

        String response = getResponse(userMessage);

        chatArea.append("Bot: " + response + "\n\n");

        inputField.setText("");
    }

    String getResponse(String message) {

        // NLP: convert input to lowercase
        message = message.toLowerCase();

        // Rule-based responses
        if (message.contains("hello") ||
            message.contains("hi") ||
            message.contains("hey")) {

            return "Hello! How can I help you?";
        }

        else if (message.contains("name")) {

            return "I am a Java-based AI Chatbot.";
        }

        else if (message.contains("java")) {

            return "Java is an object-oriented programming language.";
        }

        else if (message.contains("ai") ||
                 message.contains("artificial intelligence")) {

            return "AI enables computers to perform tasks that normally require human intelligence.";
        }

        else if (message.contains("n||||lp") ||
                 message.contains("natural language")) {

            return "NLP helps computers understand and process human language.";
        }

        else if (message.contains("college")) {

            return "College is a great place to learn, develop skills and build your career.";
        }

        else if (message.contains("study") ||
                 message.contains("exam")) {

            return "Create a study schedule and practice regularly for better results.";
        }

        else if (message.contains("thank")) {

            return "You're welcome!";
        }

        else if (message.contains("bye")) {

            return "Goodbye! Have a great day!";
        }

        else if (message.contains("how are you")) {

            return "I am doing great! Thanks for asking.";
        }

        else {
            return "Sorry, I don't understand that. Please ask another question.";
        }
    }

    public static void main(String[] args) {

        new AIChatbot();
    }
}