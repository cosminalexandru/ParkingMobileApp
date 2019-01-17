package project.parking_app.screens.parkingLotScreen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import project.parking_app.R;

public class BigRowViewHolder extends RecyclerView.ViewHolder {
    private View smallPot1, smallPot2, largePot1, largePot2, largePot3, largePot4, largePot5, largePot6,
            largePot7, largePot8, largePot9, largePot10;

    private TextView smallSpotsStatistics, largeSpotsStatistics;

    BigRowViewHolder(@NonNull View itemView) {
        super(itemView);
        smallPot1 = itemView.findViewById(R.id.smallPot1);
        smallPot2 = itemView.findViewById(R.id.smallPot2);
        largePot1 = itemView.findViewById(R.id.largePot1);
        largePot2 = itemView.findViewById(R.id.largePot2);
        largePot3 = itemView.findViewById(R.id.largePot3);
        largePot4 = itemView.findViewById(R.id.largePot4);
        largePot5 = itemView.findViewById(R.id.largePot5);
        largePot6 = itemView.findViewById(R.id.largePot6);
        largePot7 = itemView.findViewById(R.id.largePot7);
        largePot8 = itemView.findViewById(R.id.largePot8);
        largePot9 = itemView.findViewById(R.id.largePot9);
        largePot10 = itemView.findViewById(R.id.largePot10);
        smallSpotsStatistics = itemView.findViewById(R.id.smallStatistics);
        largeSpotsStatistics = itemView.findViewById(R.id.largeStatistics);
    }

    public View getSmallPot1() {
        return smallPot1;
    }

    public void setSmallPot1(View smallPot1) {
        this.smallPot1 = smallPot1;
    }

    public View getSmallPot2() {
        return smallPot2;
    }

    public void setSmallPot2(View smallPot2) {
        this.smallPot2 = smallPot2;
    }

    public View getLargePot1() {
        return largePot1;
    }

    public void setLargePot1(View largePot1) {
        this.largePot1 = largePot1;
    }

    public View getLargePot2() {
        return largePot2;
    }

    public void setLargePot2(View largePot2) {
        this.largePot2 = largePot2;
    }

    public View getLargePot3() {
        return largePot3;
    }

    public void setLargePot3(View largePot3) {
        this.largePot3 = largePot3;
    }

    public View getLargePot4() {
        return largePot4;
    }

    public void setLargePot4(View largePot4) {
        this.largePot4 = largePot4;
    }

    public View getLargePot5() {
        return largePot5;
    }

    public void setLargePot5(View largePot5) {
        this.largePot5 = largePot5;
    }

    public View getLargePot6() {
        return largePot6;
    }

    public void setLargePot6(View largePot6) {
        this.largePot6 = largePot6;
    }

    public View getLargePot7() {
        return largePot7;
    }

    public void setLargePot7(View largePot7) {
        this.largePot7 = largePot7;
    }

    public View getLargePot8() {
        return largePot8;
    }

    public void setLargePot8(View largePot8) {
        this.largePot8 = largePot8;
    }

    public View getLargePot9() {
        return largePot9;
    }

    public void setLargePot9(View largePot9) {
        this.largePot9 = largePot9;
    }

    public View getLargePot10() {
        return largePot10;
    }

    public void setLargePot10(View largePot10) {
        this.largePot10 = largePot10;
    }

    TextView getSmallSpotsStatistics() {
        return smallSpotsStatistics;
    }

    public void setSmallSpotsStatistics(TextView smallSpotsStatistics) {
        this.smallSpotsStatistics = smallSpotsStatistics;
    }

    TextView getLargeSpotsStatistics() {
        return largeSpotsStatistics;
    }

    public void setLargeSpotsStatistics(TextView largeSpotsStatistics) {
        this.largeSpotsStatistics = largeSpotsStatistics;
    }
}
