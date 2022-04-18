
package br.banco.util;

import java.util.List;
import java.util.Arrays;
import java.io.IOException;

import java.io.IOException;
import java.io.InputStream;

import java.io.ByteArrayOutputStream;

import com.google.gson.Gson;

public abstract class JSONtoObject{

    protected abstract InputStream getStream() throws IOException;

    // Conteudo do Arquivo
    public String conteudo() throws IOException {
        return lerConteudo();
    }

    /// Retorna como uma lista de JSON
    public <T> List<T> fromJsonAsList(Class<T[]> clazz) throws IOException {
        return Arrays.asList(new Gson().fromJson(conteudo(), clazz));
    }

    // Ler conteudo do Json
    private String lerConteudo() throws IOException {
        // Using try-catch just for safe closing resources in case of IOException.
        try (InputStream inputStream = getStream();
             ByteArrayOutputStream result = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString();
        } catch (IOException e) {
            throw e;
        }
    }
    
}