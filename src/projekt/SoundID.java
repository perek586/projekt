import java.util.HashMap;

public class SoundID {
    HashMap<String, int[]> idMap = new HashMap<String, int[]>();
    private final String [] idType = {"Attacks", "Effects", "Buffs", "Music"};
    private final int numberOfIDs = 4;
    private final int effectIncrement = numberOfIDs;
    private final int buffIncrement = effectIncrement+numberOfIDs;
    private final int musicIncrement = buffIncrement+numberOfIDs;

    public SoundID(){
        /** Adds unique ids for up to 4 channels for every sound category */
        for(int i = 0; i < idType.length;i++){
            idMap.put(idType[i], new int[numberOfIDs]);
        }

        for(int i = 0; i<numberOfIDs; i++){
            idMap.get(idType[0])[i] = i;
            idMap.get(idType[1])[i] = i+effectIncrement;
            idMap.get(idType[2])[i] = i+buffIncrement;
            idMap.get(idType[3])[i] = i+musicIncrement;
        }
    }

    public int getAttackID(int index){
        return idMap.get(idType[0])[index];
    }

    public int getEffectID(int index){
        return idMap.get(idType[1])[index];
    }

    public int getBuffID(int index){
        return idMap.get(idType[2])[index];
    }

    public int getMusicID(int index){
        return idMap.get(idType[3])[index];
    }

    public void printSoundIDMap(){
        for(int i = 0; i<numberOfIDs;i++){
            System.out.println("Key name ("+i+"): "+ idMap.keySet().toArray()[i] +"\nValues: ");
            for(int j = 0; j<numberOfIDs; j++){
                System.out.println(idMap.get(idMap.keySet().toArray()[i])[j]);
            }
        }

    }
}
