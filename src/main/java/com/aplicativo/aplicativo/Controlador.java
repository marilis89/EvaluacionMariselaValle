/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicativo.aplicativo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Stalin
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controlador {
    
  @GetMapping("/imprimirNumeros")
    public String imprimirNumeros() {
        StringBuilder resultado = new StringBuilder();

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                resultado.append("SOMOS BA\n");
            } else if (i % 3 == 0) {
                resultado.append("SOMOS\n");
            } else if (i % 5 == 0) {
                resultado.append("BA\n");
            } else {
                resultado.append(i).append("\n");
            }
        }

        return resultado.toString();
    }

     @GetMapping("/ordenarDeMayorAMenor")
    public int[] ordenarDeMayorAMenor() {
        int[] arreglo = {50, 5, 10, 36, 25, 85, 23, 65};

        // Ordenar el arreglo de mayor a menor
        Integer[] arregloInteger = Arrays.stream(arreglo).boxed().toArray(Integer[]::new);
        Arrays.sort(arregloInteger, Collections.reverseOrder());

        // Convertir el arreglo ordenado de Integer a int
        int[] arregloOrdenado = Arrays.stream(arregloInteger).mapToInt(Integer::intValue).toArray();

        return arregloOrdenado;
    }
    
   @GetMapping("/verificarAnagrama")
    public String verificarAnagrama(@RequestParam String cadena1, @RequestParam String cadena2) {
        if (sonAnagramas(cadena1, cadena2)) {
            return "Las cadenas son anagramas.";
        } else {
            return "Las cadenas no son anagramas.";
        }
    }

    private boolean sonAnagramas(String cadena1, String cadena2) {
        // Eliminar espacios y convertir a minúsculas para comparación sin distinción de mayúsculas y minúsculas
        String cadena1Procesada = cadena1.replaceAll("\\s", "").toLowerCase();
        String cadena2Procesada = cadena2.replaceAll("\\s", "").toLowerCase();

        // Verificar si las longitudes son diferentes
        if (cadena1Procesada.length() != cadena2Procesada.length()) {
            return false;
        }

        // Convertir las cadenas a arreglos de caracteres y ordenarlos
        char[] charArray1 = cadena1Procesada.toCharArray();
        char[] charArray2 = cadena2Procesada.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Comparar los arreglos ordenados
        return Arrays.equals(charArray1, charArray2);
    }
    
    
  
}





