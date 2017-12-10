package com.nullpointerxception.game;

import static org.junit.Assert.*;
import org.junit.Test;

import com.nullpointerxception.exceptions.InvalidCommandFormatException;

public class InputParserTest{
    
    @Test
    public final void returnsUseItem(){
        try{
            assertEquals("POTION", InputParser.parseUse("USE POTION 2"));
        }catch(InvalidCommandFormatException e){
            e.getMessage();
        }
        
    }

    @Test(expected = InvalidCommandFormatException.class)
    public final void InvalidCommandFormatException() throws InvalidCommandFormatException{
        InputParser.parseUse("u");
    }

    

}