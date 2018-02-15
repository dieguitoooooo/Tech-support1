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
    HashMap<HashSet<String>, String> responsesAboutInput;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();

        responsesAboutInput = new HashMap<>();

        HashSet<String> set01 = new HashSet<>();
        set01.add("free");
        set01.add("app");

        HashSet<String> set02 = new HashSet<>();
        set02.add("free");

        HashSet<String> set03 = new HashSet<>();
        set03.add("app");

        HashSet<String> set04 = new HashSet<>();
        set04.add("linux");
        set04.add("problem");
        set04.add("crash");

        responsesAboutInput.put(set04, "The system cannot find the file specified.");
        responsesAboutInput.put(set01, "Access is denied.");
        responsesAboutInput.put(set02, "An attempt was made to load a program with an incorrect format.");
        responsesAboutInput.put(set03, "The system cannot move the file to a different disk drive.");

    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput)
    {
        String responses = null;

        responses = responsesAboutInput.get(userInput);

        if (responses == null){
            if(responde.size() >0){
                responses = responde.remove(aleatorio.nextInt(responde.size()));
            }
            else{
                responses = "Sorry, I dont understand your question!";
            }
        }
        return responses;
    }

    private void createDefaultesponses()
    {
        responde = new ArrayList<>();

        responde.add("Thank You");
        responde.add("Congratulations");
        responde.add("Really?");
        responde.add("Thats Right");
        responde.add("Okay");
    }

}
