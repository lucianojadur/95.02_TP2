public class Country {
    private String name;
    private int armyAmount;

    public Country(String name) {
        this.name = name;
        this.armyAmount = 1;

    }

    public int getArmyAmount(){
        return armyAmount;
    }

    public String getName(){
        return this.name;
    }
    public void addArmy(int amount){
        armyAmount = armyAmount + amount;
    }

    public Integer diceAmount() {
        if(armyAmount < 3){
            return armyAmount;
        }
        return 3;
    }

    public void removeArmy(Integer lostArmy) {
        if(armyAmount >= lostArmy){
            armyAmount = armyAmount - lostArmy;
        } else{
            armyAmount = 0;
        }
    }


}
