public class HanoiTowers{
    
    public void HanoiTowers(int Towers){
        auxHanoiTowers(Towers, 1, 2, 3);
    }
    
    private void auxHanoiTowers(int Towers, int Start, int Intermediate, int End){
        if(Towers > 1){
            auxHanoiTowers(Towers - 1, Start, End, Intermediate);
            System.out.println("Tower from " + Start + " to " + End);
            auxHanoiTowers(Towers - 1, Intermediate, Start, End);
        } else
        System.out.println("Tower from " + Start + " to " + End);
    }
}