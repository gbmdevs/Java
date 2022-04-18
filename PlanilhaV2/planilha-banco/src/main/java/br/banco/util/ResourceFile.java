
package br.banco.util;

import java.io.FileNotFoundException;
import java.io.InputStream;

import br.banco.util.JSONtoObject;

public class ResourceFile extends JSONtoObject {

    private final String fileName;

    public ResourceFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected InputStream getStream() throws FileNotFoundException {
        InputStream stream = ResourceFile.class.getResourceAsStream("/" + fileName);
        System.out.println("Arquivo: " + stream.toString());
        if (stream == null) {
            throw new FileNotFoundException("Arquvivo nao Encotrado " + fileName);
        }
        return stream;
    }

}