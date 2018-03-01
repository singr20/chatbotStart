/**
 * A program to carry on conversations with a hu
 * n user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases
 * </li></ul>
 * Tasks
 * 1) handle response to good or bad moods
 * 2) handle request for time or date
 * 3) handle request for time until an event (spring break, easter, summer)
 * 4) history of EA bot
 * 5) US History
 * 6) Misc
 * 
 * 
 */
public class chatbot
{
    /**
     * Get a default greeting
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "Testing";

        response = getRandomResponse();
        if(findKeyword(statement, "cat", 0) > -1){
            response = "How is your cat?";
        }

        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        String response = "";
        return response;
    }

    private int findKeyword(String statement, String goal, int startPos){
        int spot = -1;
        statement = statement.toLowerCase();  
        goal = goal.toLowerCase(); 
        
        String word = "";
        if(statement.indexOf(goal) == 0){
            word = statement.substring(statement.indexOf(goal), statement.indexOf(goal) + 1 + goal.length());
            word = word.toLowerCase();
            if(word.equals(goal + " ")){
                spot = statement.indexOf(goal);
                System.out.println("test1");
            }
            else{
                spot = -1;
            }
        }
        else if(statement.indexOf(goal) == statement.length() - goal.length()-1){
            word = statement.substring(statement.indexOf(goal) - 1, goal.length() + statement.indexOf(goal));
            word.toLowerCase();
            if (word.equals(" " + goal)){
                spot = statement.indexOf(goal);
                System.out.println("test2");
            }
            else{
                spot = -1;
            }
        }   
        else if(statement.indexOf(goal) != -1 && spot == -1) {
            word = statement.substring(statement.indexOf(goal) - 1, goal.length() + statement.indexOf(goal) + 1);
            word.toLowerCase();
            if (word.equals(" " + goal + " ") || word.equals(goal + " ") || word.equals(" " + goal + ".") ||word.equals(goal + ".")){
                spot = statement.indexOf(goal);
                System.out.println("test3");
            }
            else{
                spot = -1;
            }
        }
        /*
        if(statement.indexOf(goal) == -1){
            spot = -1;
        }
        */
        return spot;
        
    }
}