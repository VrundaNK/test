package com.company.rank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vnagpurkar on 7/6/16.
 */
public class GetRankInNumberStream {

    List<NumberWithRank> numbers;

    public GetRankInNumberStream() {
        numbers = new ArrayList<NumberWithRank>();
    }

    public void track(int x) {

        int rank;
        for(NumberWithRank n: numbers) {

            if(x <= n.getNumber()) {
                rank = n.getRank();
                n.setRank(rank + 1);
            }
        }
        NumberWithRank newNumber = new NumberWithRank(x);
        numbers.add(newNumber);
    }

    public int getRankOfNumber (int x) {

        return -1;
    }
}
