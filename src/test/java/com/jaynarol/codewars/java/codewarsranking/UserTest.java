package com.jaynarol.codewars.java.codewarsranking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UserTest {

    private UserBetter user = new UserBetter();

    @Test
    public void defaultUserValue() {
        assertThat(user.rank, is(equalTo(-8)));
        assertThat(user.progress, is(equalTo(0)));
    }

    @Test
    public void incProgressSameRank_ShouldProgressBeAdd3Point() {
        user.incProgress(-8);
        assertThat(user.progress, is(equalTo(3)));
    }

    @Test
    public void incProgressLower1Rank_ShouldProgressBeAdd1Point() {
        user.rank = -7;
        user.incProgress(-8);
        assertThat(user.progress, is(equalTo(1)));
    }

    @Test
    public void incProgressLower2Rank_ShouldProgressNotAddPoint() {
        user.rank = -6;
        user.incProgress(-8);
        assertThat(user.progress, is(equalTo(0)));
    }

    @Test
    public void incProgressHigher1Rank_ShouldProgressBeAddTenPoint() {
        user.rank = -8;
        user.incProgress(-7);
        assertThat(user.progress, is(equalTo(10)));
    }

    @Test
    public void incProgressHigher1Rank_ShouldProgressBeAddWitnProgressionPoint() {
        user.rank = -8;
        user.incProgress(-5);
        assertThat(user.progress, is(equalTo(90)));
    }


    @Test
    public void incProgressOver100ShouldBeRankUp() {
        user.incProgress(-4); //160
        assertThat(user.progress, is(equalTo(60)));
        assertThat(user.rank, is(equalTo(-7)));
    }

    @Test
    public void userRankNothaveZero() {
        user.rank = -1;
        user.incProgress(4);
        assertThat(user.progress, is(equalTo(60)));
        assertThat(user.rank, is(equalTo(1)));
    }

    @Test
    public void userRankNotOverEight() {
        user.rank = 8;
        user.incProgress(8);
        assertThat(user.progress, is(equalTo(0)));
        assertThat(user.rank, is(equalTo(8)));
    }

    @Test
    public void userRankShouldBePassZero() {
        user.rank = -8;

        user.incProgress(1);
        assertThat(user.rank, is(equalTo(-2)));
        assertThat(user.progress, is(equalTo(40)));

        user.incProgress(1);
        assertThat(user.rank, is(equalTo(-2)));
        assertThat(user.progress, is(equalTo(80)));

        user.incProgress(1);
        assertThat(user.rank, is(equalTo(-1)));
        assertThat(user.progress, is(equalTo(20)));

        user.incProgress(1);
        assertThat(user.rank, is(equalTo(-1)));
        assertThat(user.progress, is(equalTo(30)));

        user.incProgress(1);
        assertThat(user.rank, is(equalTo(-1)));
        assertThat(user.progress, is(equalTo(40)));

        user.incProgress(2);
        assertThat(user.rank, is(equalTo(-1)));
        assertThat(user.progress, is(equalTo(80)));

        user.incProgress(2);
        assertThat(user.rank, is(equalTo(1)));
        assertThat(user.progress, is(equalTo(20)));

        user.incProgress(-1);
        assertThat(user.rank, is(equalTo(1)));
        assertThat(user.progress, is(equalTo(21)));

    }

}
