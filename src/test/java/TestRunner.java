package src;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO EJECUCIÓN DESDE TESTRUNNER ===");
        
        // Aquí le llamamos a JUnit que ejecute nuestra clase de pruebas y El TestParticionEstado
        Result resultado = JUnitCore.runClasses(BibliotecaMusicalTest.class, TestParticionEstado.class);


        // 1. Mostramos los métodos que han fallado aposta
        System.out.println("\n DETALLE DE PRUEBAS FALLIDAS:");
        for (Failure fallo : resultado.getFailures()) {
            System.out.println("- Ha fallado el método: " + fallo.getDescription().getMethodName());
            System.out.println("  Motivo del fallo: " + fallo.getMessage());
            System.out.println("--------------------------------------------------");
        }
        
        // 2. Mostramos el resumen global por pantalla
        System.out.println("\n RESUMEN FINAL:");
        System.out.println("Total de pruebas ejecutadas: " + resultado.getRunCount());
        System.out.println("Total de pruebas fallidas: " + resultado.getFailureCount());
        
        // Comprobamos si el resultado global fue exitoso o no
        if (resultado.wasSuccessful()) {
            System.out.println("Resultado global: ¡TODO PERFECTO! (Verde)");
        } else {
            System.out.println("Resultado global: ATENCIÓN, HAY PRUEBAS FALLIDAS (Rojo)");
        }
    }
}