package com.example.deleterecyclerviewitemthroughswipee.Helper;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.deleterecyclerviewitemthroughswipee.Adapter.CardListAdapter;
import com.example.deleterecyclerviewitemthroughswipee.MainActivity;

import static android.support.v7.widget.helper.ItemTouchHelper.ACTION_STATE_SWIPE;

public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback {


    private RecyclerItemTouchHelperListener listener;
    final float buttonWidth=300;
    boolean swipeBack=false;


    public RecyclerItemTouchHelper(int dragDirs, int swipeDirs, RecyclerItemTouchHelperListener listener) {
        super(dragDirs, swipeDirs);
        this.listener= listener;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (listener !=null){
            listener.onSwiped(viewHolder,i,viewHolder.getAdapterPosition());
        }

    }


    @Override
    public void clearView (RecyclerView recyclerView,RecyclerView.ViewHolder viewHolder){
        View foregroundView =((CardListAdapter.MyViewHolder)viewHolder).viewForeground;
        getDefaultUIUtil().clearView(foregroundView);
    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection){

        if (swipeBack){
            swipeBack=false;
            return 0;
        }

        return super.convertToAbsoluteDirection(flags,layoutDirection);
    }



    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState){
        if (viewHolder !=null){
            View foregroundView =((CardListAdapter.MyViewHolder)viewHolder).viewForeground;
            getDefaultUIUtil().onSelected(foregroundView);
        }
    }


    @Override
    public void onChildDraw(Canvas c,RecyclerView recyclerView,RecyclerView.ViewHolder viewHolder,float dX, float dY,int actionState,boolean isCurrentlyActive) {


        View foregroundView = ((CardListAdapter.MyViewHolder) viewHolder).viewForeground;
        getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY, actionState, isCurrentlyActive);

//        if (dX>0){ // Swiping to the right
//
//            View foregroundView =((CardListAdapter.MyViewHolder)viewHolder).viewForeground;
//            getDefaultUIUtil().onDraw(c,recyclerView,foregroundView,dX,dY,actionState,isCurrentlyActive);
//        }else if (dX<buttonWidth){// left
//
//            if (actionState == ACTION_STATE_SWIPE) {
//                setTouchListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//
//
//                View foregroundView =((CardListAdapter.MyViewHolder)viewHolder).viewForeground;
//                getDefaultUIUtil().onDraw(c,recyclerView,foregroundView,dX,dY,actionState,isCurrentlyActive);
//            }
        //     }
    }

//    private void setTouchListener(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, final float dX, float dY, int actionState, boolean isCurrentlyActive) {
//        recyclerView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//
//                if (dX<0){
//
//                   // Toast.makeText(RecyclerItemTouchHelper.this,"Left",Toast.LENGTH_SHORT).show();
//                    swipeBack=event.getAction()== MotionEvent.ACTION_CANCEL || event.getAction()==MotionEvent.ACTION_UP;
//                }
//
//                return false;
//            }
//        });
//
//    }


    @Override
    public void onChildDrawOver(Canvas c,RecyclerView recyclerView,RecyclerView.ViewHolder viewHolder,float dX, float dY,int actionState, boolean isCurrentlyActive){

        View foregroundView =((CardListAdapter.MyViewHolder)viewHolder).viewForeground;
        getDefaultUIUtil().onDrawOver(c,recyclerView,foregroundView,dX,dY,actionState,isCurrentlyActive);
    }
}
