package edu.emmapi.controllers;

import edu.emmapi.services.AIService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AIController {
    @FXML private Label predictionLabel;

    private AIService aiService = new AIService();

    @FXML
    public void initialize() {
        float[] inputData = {1.0f, 2.0f, 3.0f}; // Données d'entrée pour la prédiction
        float prediction = aiService.predict(inputData);
        predictionLabel.setText("Prédiction : " + prediction); // Affiche la prédiction dans l'interface
    }
}