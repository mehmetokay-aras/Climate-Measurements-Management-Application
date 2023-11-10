public class Main {
    public static void main(String[] args) {
        RadiationAbsorption deneme1 = new RadiationAbsorption();
        RadiationAbsorption deneme2 = new RadiationAbsorption(15);
        RadiationAbsorption deneme3 = new RadiationAbsorption(deneme1);
        System.out.println(deneme1.toString());
        System.out.println(deneme2.toString());
        System.out.println(deneme3.toString());
    }
}