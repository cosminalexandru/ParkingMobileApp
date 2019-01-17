package project.parking_app.screens.parkingLotScreen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import project.parking_app.R;

public class LevelTitleViewHolder extends RecyclerView.ViewHolder {
    private TextView title;

    LevelTitleViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.level_number);
    }

    public TextView getTitle() {
        return title;
    }
}
