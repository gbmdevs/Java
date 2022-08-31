package br.com.springboot.process;

// Model

import br.com.springboot.model.Coffee;

// Processo para o Batch
import org.springframework.batch.item.ItemProcessor;

public class CoffeeItemProcessor implements ItemProcessor<Coffee, Coffee>{

    @Override
    public Coffee process(final Coffee coffee) throws Exception{
        String brand  = coffee.getBrand().toUpperCase();
        String origin = coffee.getOrigin().toUpperCase();
        String chracteristics = coffee.getCharacteristics().toUpperCase(); 

        Coffee transformedCoffee = new Coffee(brand,origin,chracteristics);

        return transformedCoffee;

    }

}