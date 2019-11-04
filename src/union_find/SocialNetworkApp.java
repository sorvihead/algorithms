package union_find;

public class SocialNetworkApp {
    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork(6);
        socialNetwork.friendship(0, 1);
        socialNetwork.friendship(0, 2);
        socialNetwork.friendship(2, 3);
        socialNetwork.friendship(4, 5);
        socialNetwork.friendship(0, 4);
        socialNetwork.friendship(0, 5);

        System.out.println(socialNetwork.getCongratsLog());
        QuickUnionUF uf = new QuickUnionUF(6);
        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(0, 4);
        System.out.println(uf.find(0));

        for (int i = 0; i < 5; i++){
            System.out.println(uf.getComponent(i));
        }
    }
}
