public class Turret {

    private String name;
    private int ammo;
    private static final int[] ammoArr = {10, 10, 0};
    private static int number = 1;
    private static int i = 0;

    Turret() {
        this.name = "Turret " + number;
        this.ammo = ammoArr[i];
        number++;
        i = (i + 1) % 3;
    }

    public void shoot() {
        if(this.ammo > 0) {
            System.out.println(this.name  + ": BOOM!");
            this.ammo--;
        } else {
            System.out.println(this.name + ": ...OOPS!");
        }
    }

    @Override
    public String toString() {
        return this.name + ", current ammo: " + this.ammo;
    }

    public static void main(String[] args) {
        Turret[] turrets = new Turret[10];
        for(int i=0; i<turrets.length; i++) {
            turrets[i] = new Turret();
        }
        for(Turret turret : turrets) {
            System.out.println(turret);
        }
        for(Turret turret : turrets) {
            turret.shoot();
        }
        for(Turret turret : turrets) {
            System.out.println(turret);
        }
    }

}