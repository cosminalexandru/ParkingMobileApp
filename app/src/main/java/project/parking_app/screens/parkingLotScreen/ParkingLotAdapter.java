package project.parking_app.screens.parkingLotScreen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import project.parking_app.R;
import project.parking_app.data.parkingLotComponent.Level;
import project.parking_app.data.parkingLotComponent.Row;
import project.parking_app.data.parkingLotComponent.Spot;
import project.parking_app.data.utils.RowType;
import project.parking_app.data.utils.SpotType;

public class ParkingLotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int BIG_ROW = 0, COMPACT_ROW = 1, LEVEL = 2;
    private List<Object> items;

    public ParkingLotAdapter(List<Object> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case BIG_ROW:
                View v1 = inflater.inflate(R.layout.big_row_element, viewGroup, false);
                viewHolder = new BigRowViewHolder(v1);
                break;
            case COMPACT_ROW:
                View v2 = inflater.inflate(R.layout.compact_row_element, viewGroup, false);
                viewHolder = new CompactRowViewHolder(v2);
                break;
            case LEVEL:
                View v3 = inflater.inflate(R.layout.level_title_element, viewGroup, false);
                viewHolder = new LevelTitleViewHolder(v3);
                break;
            default:
                View v = inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
                viewHolder = new CompactRowViewHolder(v);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case BIG_ROW:
                BigRowViewHolder vh1 = (BigRowViewHolder) viewHolder;
                configureViewHolderBigRow(vh1, position);
                break;
            case COMPACT_ROW:
                CompactRowViewHolder vh2 = (CompactRowViewHolder) viewHolder;
                configureViewHolderCompactRow(vh2, position);
                break;
            case LEVEL:
                LevelTitleViewHolder vh3 = (LevelTitleViewHolder) viewHolder;
                configureViewHolderLevelNumber(vh3, position);
            default:
                break;
        }
    }

    private void configureViewHolderLevelNumber(LevelTitleViewHolder vh3, int position) {
        Level level = (Level) items.get(position);
        if (level != null) {
            vh3.getTitle().setText("Level " + level.getLevelNumber());
        }

    }

    private void configureViewHolderCompactRow(CompactRowViewHolder vh1, int position) {
        Row compactRow = (Row) items.get(position);
        if (compactRow != null) {
            vh1.getSmallSpotsStatistics().setText(compactRow.getStatistics().get(SpotType.SMALL).toString());
            vh1.getCompactSpotsStatistics().setText(Integer.toString(compactRow.getStatistics().get(SpotType.COMPACT)));
            List<Spot> spots = compactRow.getSpots();
            if (spots.get(0).getAvailability()) {
                View view = vh1.getSmallPot1();
                view.setBackgroundResource(R.color.smallPotAvailable);
                vh1.setSmallPot1(view);
            } else {
                View view = vh1.getSmallPot1();
                view.setBackgroundResource(R.color.red);
                vh1.setSmallPot1(view);
            }
            if (spots.get(21).getAvailability()) {
                View view = vh1.getSmallPot2();
                view.setBackgroundResource(R.color.smallPotAvailable);
                vh1.setSmallPot2(view);
            } else {
                View view = vh1.getSmallPot2();
                view.setBackgroundResource(R.color.red);
                vh1.setSmallPot2(view);
            }
            if (spots.get(1).getAvailability()) {
                View view = vh1.getCompactPot1();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot1(view);
            } else {
                View view = vh1.getCompactPot1();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot1(view);
            }

            if (spots.get(2).getAvailability()) {
                View view = vh1.getCompactPot2();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot2(view);
            } else {
                View view = vh1.getCompactPot2();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot2(view);
            }
            if (spots.get(3).getAvailability()) {
                View view = vh1.getCompactPot3();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot3(view);
            } else {
                View view = vh1.getCompactPot3();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot3(view);
            }
            if (spots.get(4).getAvailability()) {
                View view = vh1.getCompactPot4();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot4(view);
            } else {
                View view = vh1.getCompactPot4();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot4(view);
            }
            if (spots.get(5).getAvailability()) {
                View view = vh1.getCompactPot5();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot5(view);
            } else {
                View view = vh1.getCompactPot5();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot5(view);
            }
            if (spots.get(6).getAvailability()) {
                View view = vh1.getCompactPot6();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot6(view);
            } else {
                View view = vh1.getCompactPot6();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot6(view);
            }
            if (spots.get(7).getAvailability()) {
                View view = vh1.getCompactPot7();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot7(view);
            } else {
                View view = vh1.getCompactPot7();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot7(view);
            }
            if (spots.get(8).getAvailability()) {
                View view = vh1.getCompactPot8();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot8(view);
            } else {
                View view = vh1.getCompactPot8();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot8(view);
            }
            if (spots.get(9).getAvailability()) {
                View view = vh1.getCompactPot9();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot9(view);
            } else {
                View view = vh1.getCompactPot9();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot9(view);
            }
            if (spots.get(10).getAvailability()) {
                View view = vh1.getCompactPot10();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot10(view);
            } else {
                View view = vh1.getCompactPot10();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot10(view);
            }
            if (spots.get(11).getAvailability()) {
                View view = vh1.getCompactPot11();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot11(view);
            } else {
                View view = vh1.getCompactPot11();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot11(view);
            }
            if (spots.get(12).getAvailability()) {
                View view = vh1.getCompactPot12();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot12(view);
            } else {
                View view = vh1.getCompactPot12();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot12(view);
            }
            if (spots.get(13).getAvailability()) {
                View view = vh1.getCompactPot13();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot13(view);
            } else {
                View view = vh1.getCompactPot13();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot13(view);
            }
            if (spots.get(14).getAvailability()) {
                View view = vh1.getCompactPot14();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot14(view);
            } else {
                View view = vh1.getCompactPot14();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot14(view);
            }
            if (spots.get(15).getAvailability()) {
                View view = vh1.getCompactPot15();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot15(view);
            } else {
                View view = vh1.getCompactPot15();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot15(view);
            }
            if (spots.get(16).getAvailability()) {
                View view = vh1.getCompactPot16();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot16(view);
            } else {
                View view = vh1.getCompactPot16();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot16(view);
            }
            if (spots.get(17).getAvailability()) {
                View view = vh1.getCompactPot17();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot17(view);
            } else {
                View view = vh1.getCompactPot17();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot17(view);
            }
            if (spots.get(18).getAvailability()) {
                View view = vh1.getCompactPot18();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot18(view);
            } else {
                View view = vh1.getCompactPot18();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot18(view);
            }
            if (spots.get(19).getAvailability()) {
                View view = vh1.getCompactPot19();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot19(view);
            } else {
                View view = vh1.getCompactPot19();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot19(view);
            }
            if (spots.get(20).getAvailability()) {
                View view = vh1.getCompactPot20();
                view.setBackgroundResource(R.color.compactPotAvailable);
                vh1.setCompactPot20(view);
            } else {
                View view = vh1.getCompactPot20();
                view.setBackgroundResource(R.color.red);
                vh1.setCompactPot20(view);
            }
        }
    }

    private void configureViewHolderBigRow(BigRowViewHolder vh2, int position) {
        Row bigRow = (Row) items.get(position);
        if (bigRow != null) {
            vh2.getSmallSpotsStatistics().setText(bigRow.getStatistics().get(SpotType.SMALL).toString());
            vh2.getLargeSpotsStatistics().setText(Integer.toString(bigRow.getStatistics().get(SpotType.LARGE)));
            List<Spot> spots = bigRow.getSpots();
            if (spots.get(0).getAvailability()) {
                View view = vh2.getSmallPot1();
                view.setBackgroundResource(R.color.smallPotAvailable);
                vh2.setSmallPot1(view);
            } else {
                View view = vh2.getSmallPot1();
                view.setBackgroundResource(R.color.red);
                vh2.setSmallPot1(view);
            }
            if (spots.get(11).getAvailability()) {
                View view = vh2.getSmallPot2();
                view.setBackgroundResource(R.color.smallPotAvailable);
                vh2.setSmallPot2(view);
            } else {
                View view = vh2.getSmallPot2();
                view.setBackgroundResource(R.color.red);
                vh2.setSmallPot2(view);
            }
            if (spots.get(1).getAvailability()) {
                View view = vh2.getLargePot1();
                view.setBackgroundResource(R.color.largePotAvailable);
                vh2.setLargePot1(view);
            } else {
                View view = vh2.getLargePot1();
                view.setBackgroundResource(R.color.red);
                vh2.setLargePot1(view);
            }
            if (spots.get(2).getAvailability()) {
                View view = vh2.getLargePot2();
                view.setBackgroundResource(R.color.largePotAvailable);
                vh2.setLargePot2(view);
            } else {
                View view = vh2.getLargePot2();
                view.setBackgroundResource(R.color.red);
                vh2.setLargePot2(view);
            }
            if (spots.get(3).getAvailability()) {
                View view = vh2.getLargePot3();
                view.setBackgroundResource(R.color.largePotAvailable);
                vh2.setLargePot3(view);
            } else {
                View view = vh2.getLargePot3();
                view.setBackgroundResource(R.color.red);
                vh2.setLargePot3(view);
            }
            if (spots.get(4).getAvailability()) {
                View view = vh2.getLargePot4();
                view.setBackgroundResource(R.color.largePotAvailable);
                vh2.setLargePot4(view);
            } else {
                View view = vh2.getLargePot4();
                view.setBackgroundResource(R.color.red);
                vh2.setLargePot4(view);
            }
            if (spots.get(5).getAvailability()) {
                View view = vh2.getLargePot5();
                view.setBackgroundResource(R.color.largePotAvailable);
                vh2.setLargePot5(view);
            } else {
                View view = vh2.getLargePot5();
                view.setBackgroundResource(R.color.red);
                vh2.setLargePot5(view);
            }
            if (spots.get(6).getAvailability()) {
                View view = vh2.getLargePot6();
                view.setBackgroundResource(R.color.largePotAvailable);
                vh2.setLargePot6(view);
            } else {
                View view = vh2.getLargePot6();
                view.setBackgroundResource(R.color.red);
                vh2.setLargePot6(view);
            }
            if (spots.get(7).getAvailability()) {
                View view = vh2.getLargePot7();
                view.setBackgroundResource(R.color.largePotAvailable);
                vh2.setLargePot7(view);
            } else {
                View view = vh2.getLargePot7();
                view.setBackgroundResource(R.color.red);
                vh2.setLargePot7(view);
            }
            if (spots.get(8).getAvailability()) {
                View view = vh2.getLargePot8();
                view.setBackgroundResource(R.color.largePotAvailable);
                vh2.setLargePot8(view);
            } else {
                View view = vh2.getLargePot8();
                view.setBackgroundResource(R.color.red);
                vh2.setLargePot8(view);
            }
            if (spots.get(9).getAvailability()) {
                View view = vh2.getLargePot9();
                view.setBackgroundResource(R.color.largePotAvailable);
                vh2.setLargePot9(view);
            } else {
                View view = vh2.getLargePot9();
                view.setBackgroundResource(R.color.red);
                vh2.setLargePot9(view);
            }
            if (spots.get(10).getAvailability()) {
                View view = vh2.getLargePot10();
                view.setBackgroundResource(R.color.largePotAvailable);
                vh2.setLargePot10(view);
            } else {
                View view = vh2.getLargePot10();
                view.setBackgroundResource(R.color.red);
                vh2.setLargePot10(view);
            }
        }

    }


    @Override
    public int getItemCount() {
        return this.items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof Level)
            return LEVEL;
        else if (items.get(position) instanceof Row)
            if (((Row) items.get(position)).getRowType() == RowType.BIG)
                return BIG_ROW;
            else if (((Row) items.get(position)).getRowType() == RowType.COMPACT)
                return COMPACT_ROW;
        return -1;
    }
}
