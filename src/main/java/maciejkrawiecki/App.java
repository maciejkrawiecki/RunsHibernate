package maciejkrawiecki;

import maciejkrawiecki.utils.HibernateUtils;

public class App {

    public static void main(String[] args) {

        HibernateUtils.getInstance().getSessionFactory().close();
    }
}
