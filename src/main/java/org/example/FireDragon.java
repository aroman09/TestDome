package org.example;

import java.util.concurrent.Callable;

interface Reptile {
    ReptileEgg lay();
}

class FireDragon  implements Reptile{
    public FireDragon() {
    }


    public static void main(String[] args) throws Exception {
        try
        {
            FireDragon fireDragon = new FireDragon();
            ReptileEgg fireegg  = fireDragon.lay();
            Reptile fireDragon2 = fireegg.hatch();
            ReptileEgg fireegg2  = fireDragon2.lay();
            Reptile firedragon3  = fireegg2.hatch();
            System.out.println("El huevo2 nace desde el reptile2 y el nuevo reptile3 ha nacido");
            System.out.println(fireDragon instanceof Reptile);
            //fireegg2.hatch();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public ReptileEgg lay() {
        return new ReptileEgg((Callable<Reptile>) new FireDragon());
    }
}

class ReptileEgg {
    private int eggcount=0;
    private Reptile reptile;
    public ReptileEgg(Callable<Reptile> createReptile) {
        this.eggcount++;

    }

    public Reptile hatch() throws Exception {
        if(this.eggcount>0){
            throw new IllegalStateException("El huevo reptile ya fue creado");
        }
        else this.eggcount++;
        return this.reptile;
    }
}