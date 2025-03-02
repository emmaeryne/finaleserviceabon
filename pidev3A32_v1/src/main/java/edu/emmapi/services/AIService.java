package edu.emmapi.services;

import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

public class AIService {
    public float predict(float[] inputData) {
        try (Graph graph = new Graph()) {
            // Charger le modèle TensorFlow (exemple simplifié)
            byte[] modelBytes = getModelBytes(); // Chargez votre modèle TensorFlow ici
            graph.importGraphDef(modelBytes);

            try (Session session = new Session(graph)) {
                // Créer un tenseur d'entrée
                Tensor<?> inputTensor = Tensor.create(inputData);

                // Exécuter le modèle
                Tensor<?> outputTensor = session.runner()
                        .feed("input", inputTensor)
                        .fetch("output")
                        .run()
                        .get(0);

                // Récupérer le résultat
                float[] output = new float[1];
                outputTensor.copyTo(output);
                return output[0]; // Retourne la prédiction
            }
        }
    }

    private byte[] getModelBytes() {
        // Chargez votre modèle TensorFlow ici (exemple simplifié)
        return new byte[0];
    }
}