
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {


    public static void main(String[] args) {


        Ticket ticket1 = new Ticket("VKO", "AUH", 10_000, 10, 16);
        Ticket ticket2 = new Ticket("DME", "AER", 2_000, 15, 19);
        Ticket ticket3 = new Ticket("DME", "PKX", 15_000, 7, 18);
        Ticket ticket4 = new Ticket("VKO", "BCN", 13_000, 10, 23);
        Ticket ticket5 = new Ticket("DME", "ORY", 15_000, 10, 21);


        System.out.println(ticket2.compareTo(ticket1));
        System.out.println(ticket4.compareTo(ticket2));
        System.out.println(ticket3.compareTo(ticket5));

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);

    }


    @Test
    public void searchTest() {
        Ticket ticket1 = new Ticket("VKO", "AUH", 10_000, 10, 16);
        Ticket ticket2 = new Ticket("DME", "AER", 2_000, 15, 19);
        Ticket ticket3 = new Ticket("DME", "AUH", 15_000, 7, 12);
        Ticket ticket4 = new Ticket("VKO", "BCN", 13_000, 10, 23);
        Ticket ticket5 = new Ticket("DME", "AUH", 14_000, 10, 16);
        Ticket ticket6 = new Ticket("DME", "AUH", 20_000, 8, 12);
        Ticket ticket7 = new Ticket("VKO", "BCN", 12_000, 8, 23);
        Ticket ticket8 = new Ticket("DME", "AUH", 11_000, 9, 16);

        AviaSouls repo = new AviaSouls();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);

        Ticket[] expected = {ticket8, ticket5, ticket3, ticket6};
        Ticket[] actual = repo.search("DME", "AUH");
//        Arrays.sort(actual);

        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void searchTest0() {
        Ticket ticket1 = new Ticket("VKO", "AUH", 10_000, 10, 16);
        Ticket ticket2 = new Ticket("DME", "AER", 2_000, 15, 19);
        Ticket ticket3 = new Ticket("DME", "AUH", 15_000, 7, 12);
        Ticket ticket4 = new Ticket("VKO", "BCN", 13_000, 10, 23);
        Ticket ticket5 = new Ticket("DME", "AUH", 14_000, 10, 16);
        Ticket ticket6 = new Ticket("DME", "AUH", 20_000, 8, 12);
        Ticket ticket7 = new Ticket("VKO", "BCN", 12_000, 8, 23);
        Ticket ticket8 = new Ticket("DME", "AUH", 11_000, 9, 16);

        AviaSouls repo = new AviaSouls();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = repo.search("VKO", "AER");
        Arrays.sort(actual);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void searchTest1() {
        Ticket ticket1 = new Ticket("VKO", "AUH", 10_000, 10, 16);
        Ticket ticket2 = new Ticket("DME", "AER", 2_000, 15, 19);
        Ticket ticket3 = new Ticket("DME", "AUH", 15_000, 7, 12);
        Ticket ticket4 = new Ticket("VKO", "BCN", 13_000, 10, 23);
        Ticket ticket5 = new Ticket("DME", "AUH", 14_000, 10, 16);
        Ticket ticket6 = new Ticket("DME", "AUH", 20_000, 8, 12);
        Ticket ticket7 = new Ticket("VKO", "BCN", 12_000, 8, 23);
        Ticket ticket8 = new Ticket("DME", "AUH", 11_000, 9, 16);

        AviaSouls repo = new AviaSouls();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);

        Ticket[] expected = {ticket1};
        Ticket[] actual = repo.search("VKO", "AUH");
        Arrays.sort(actual);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void searchWithComparator() {

        Ticket ticket1 = new Ticket("VKO", "AUH", 10_000, 10, 16);
        Ticket ticket2 = new Ticket("DME", "AER", 2_000, 15, 19);
        Ticket ticket3 = new Ticket("DME", "AUH", 15_000, 7, 12);
        Ticket ticket4 = new Ticket("VKO", "BCN", 13_000, 10, 23);
        Ticket ticket5 = new Ticket("DME", "AUH", 14_000, 10, 16);
        Ticket ticket6 = new Ticket("DME", "AUH", 20_000, 8, 12);
        Ticket ticket7 = new Ticket("VKO", "BCN", 12_000, 8, 23);
        Ticket ticket8 = new Ticket("DME", "AUH", 11_000, 9, 16);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        AviaSouls repo = new AviaSouls();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);


        Ticket[] expected = {ticket6, ticket3, ticket5, ticket8};
        Ticket[] actual = repo.searchAndSortBy("DME", "AUH", timeComparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void searchWithComparator0() {


        Ticket ticket1 = new Ticket("VKO", "AUH", 10_000, 10, 16);
        Ticket ticket2 = new Ticket("DME", "AER", 2_000, 15, 19);
        Ticket ticket3 = new Ticket("DME", "AUH", 15_000, 7, 12);
        Ticket ticket4 = new Ticket("VKO", "BCN", 13_000, 10, 23);
        Ticket ticket5 = new Ticket("DME", "AUH", 14_000, 10, 16);
        Ticket ticket6 = new Ticket("DME", "AUH", 20_000, 8, 12);
        Ticket ticket7 = new Ticket("VKO", "BCN", 12_000, 8, 23);
        Ticket ticket8 = new Ticket("DME", "AUH", 11_000, 9, 16);

        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls repo = new AviaSouls();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);


        Ticket[] expected = {};
        Ticket[] actual = repo.searchAndSortBy("DME", "BCN", timeComparator);


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void searchWithComparator1() {


        Ticket ticket1 = new Ticket("VKO", "AUH", 10_000, 10, 16);
        Ticket ticket2 = new Ticket("DME", "AER", 2_000, 15, 19);
        Ticket ticket3 = new Ticket("DME", "AUH", 15_000, 7, 12);
        Ticket ticket4 = new Ticket("VKO", "BCN", 13_000, 10, 23);
        Ticket ticket5 = new Ticket("DME", "AUH", 14_000, 10, 16);
        Ticket ticket6 = new Ticket("DME", "AUH", 20_000, 8, 12);
        Ticket ticket7 = new Ticket("VKO", "BCN", 12_000, 8, 23);
        Ticket ticket8 = new Ticket("DME", "AUH", 11_000, 9, 16);

        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls repo = new AviaSouls();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);


        Ticket[] expected = {ticket1};
        Ticket[] actual = repo.searchAndSortBy("VKO", "AUH", timeComparator);


        Assertions.assertArrayEquals(expected, actual);
    }

}
