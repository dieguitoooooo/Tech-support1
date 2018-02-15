import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    Random aleatorio;
    ArrayList<String> responde;
    HashMap<String, String> responsesAboutInput;
    
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        responde = new ArrayList<>();
        responsesAboutInput = new HashMap<>();
        
        responde.add("Thank You");
        responde.add("Congratulations");
        responde.add("Really?");
        responde.add("Thats Right");
        responde.add("Okay");
        
        responsesAboutInput.put("Windows", "The system cannot find the file specified.");
        responsesAboutInput.put("Android", "Access is denied.");
        responsesAboutInput.put("IOs", "An attempt was made to load a program with an incorrect format.");
        responsesAboutInput.put("Linux", "The system cannot move the file to a different disk drive.");
        responsesAboutInput.put("Solaris", "The device does not recognize the command.");

    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput)
    {
        String responses = null;
        Iterator<String> iterator = userInput.iterator();
        String userInputString = iterator.next();
        responses = responsesAboutInput.get(userInputString);
        if (responses == null){
            responses = responde.get(aleatorio.nextInt(responde.size()));
        }
        return responses;
    }
}
