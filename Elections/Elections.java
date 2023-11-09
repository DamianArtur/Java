import java.util.HashMap;

public class Elections {
    private static final String VOTES =
            "Hilary,Sydnie Jernigan,Floryda\n" +
                    "Hilary,Meagan Fleming,Ohio\n" +
                    "Hilary,Denzil Samuelson,Nowy Jork\n" +
                    "Hilary,Noel Dyer,Arizona\n" +
                    "Donald,Ralf Darrell,Nowy Jork\n" +
                    "Donald,Kerr Norwood,Arizona\n" +
                    "Hilary,Desiree Morin,Nowy Jork\n" +
                    "Donald,Christa Jefferson,Ohio\n" +
                    "Donald,Avaline Romilly,Arizona\n" +
                    "Donald,Caelan Aylmer,Floryda\n" +
                    "Hilary,Kaydence Hepburn,Nowy Jork\n" +
                    "Hilary,Tobias Thorburn,Arizona\n" +
                    "Donald,Lester Royceston,Floryda\n" +
                    "Hilary,Hazel Mann,Nowy Jork\n" +
                    "Donald,Christa Jefferson,Ohio\n" +
                    "Hilary,Hilda Herman,Nowy Jork\n" +
                    "Hilary,Berenice Derrickson,Nowy Jork\n" +
                    "Hilary,Patsy Waters,Nowy Jork\n" +
                    "Hilary,Fran Elliott,Ohio\n" +
                    "Hilary,Denzil Samuelson,Nowy Jork\n" +
                    "Donald,Augusta Tasker,Nowy Jork\n" +
                    "Donald,Fox Sherburne,Arizona\n" +
                    "Donald,Christa Jefferson,Ohio\n" +
                    "Hilary,Desiree Morin,Nowy Jork\n" +
                    "Donald,Christa Jefferson,Ohio";

    public static HashMap<String, String> createDirectHashMap(String VOTES) {
        HashMap<String, String> directHashMap= new HashMap<>();
        String[] arrFromString = VOTES.split("\n");
        for(String vote : arrFromString) {
            String[] arrOneVote = vote.split(",");
            if(!directHashMap.containsKey(arrOneVote[1] + arrOneVote[2])) {
                directHashMap.put(arrOneVote[1] + arrOneVote[2], arrOneVote[0]);
            }
        }
        return directHashMap;
    }

    public static String findWinnerDirect(HashMap<String, String> directHashMap) {
        int hilaryVotes = 0;
        int donaldVotes = 0;
        for(String vote : directHashMap.keySet()) {
            if(directHashMap.get(vote).equals("Hilary")) {
                hilaryVotes++;
            } else {
                donaldVotes++;
            }
        }
        if(hilaryVotes > donaldVotes) {
            return "Hilary";
        } else if(donaldVotes > hilaryVotes) {
            return "Donald";
        } else {
            return "Remis?";
        }
    }

    public static HashMap<String, HashMap<String, String>> createIndirectHashMap(String VOTES) {
        HashMap<String, HashMap<String, String>> indirectHashMap = new HashMap<>();
        String[] arrFromString = VOTES.split("\n");
        for(String vote : arrFromString) {
            String[] arrOneVote = vote.split(",");
            if(!indirectHashMap.containsKey(arrOneVote[2])) {
                HashMap<String, String> voteInState = new HashMap<>();
                indirectHashMap.put(arrOneVote[2], voteInState);
            }
            if(!indirectHashMap.get(arrOneVote[2]).containsKey(arrOneVote[0])) {
                indirectHashMap.get(arrOneVote[2]).put(arrOneVote[1], arrOneVote[0]);
            }
        }
        return indirectHashMap;
    }

    public static String findWinnerIndirect(HashMap<String, HashMap<String, String>> indirectHashMap) {
        int hilaryWinStates = 0;
        int donaldWinStates = 0;
        for(String state : indirectHashMap.keySet()) {
            int hilaryVotes = 0;
            int donaldVotes = 0;
            for(String vote : indirectHashMap.get(state).keySet()) {
                if(indirectHashMap.get(state).get(vote).equals("Hilary")) {
                    hilaryVotes++;
                } else {
                    donaldVotes++;
                }
            }
            if(hilaryVotes > donaldVotes) {
                hilaryWinStates++;
            } else {
                donaldWinStates++;
            }
        }
        if(hilaryWinStates > donaldWinStates) {
            return "Hilary";
        } else if(donaldWinStates > hilaryWinStates) {
            return "Donald";
        } else {
            return "Remis?";
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> directHashMap = createDirectHashMap(VOTES);
        System.out.println("W głosowaniu bezposrenim wygral(a): " + findWinnerDirect(directHashMap));
        HashMap<String, HashMap<String, String>> indirectHashMap = createIndirectHashMap(VOTES);
        System.out.println("W głosowaniu posrenim wygral(a): " + findWinnerIndirect(indirectHashMap));
    }
}