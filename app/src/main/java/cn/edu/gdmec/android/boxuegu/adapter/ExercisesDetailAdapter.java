package cn.edu.gdmec.android.boxuegu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.boxuegu.R;
import cn.edu.gdmec.android.boxuegu.bean.ExercisesBean;
import cn.edu.gdmec.android.boxuegu.utils.AnalysisUtils;

/**
 * Created by apple on 18/4/17.
 */

public class ExercisesDetailAdapter extends RecyclerView.Adapter<ExercisesDetailAdapter.ViewHolder> {
    private List<ExercisesBean> objects = new ArrayList<ExercisesBean>();
    private ArrayList<String> selectedPosition = new ArrayList<String>();
    private Context mContext;
    private OnSelectListener onSelectListener;
    private MyItemClickListener mItemClickListener;

    public ExercisesDetailAdapter(Context context, OnSelectListener onSelectListener, MyItemClickListener mItemClickListener) {
        this.mContext = context;
        this.onSelectListener = onSelectListener;
        this.mItemClickListener = mItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercises_detail_list_item, parent, false);
        return new ViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        initializeViews(objects.get(position), holder, position);
    }

    public void setData(List<ExercisesBean> objects) {
        this.objects = objects;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    private void initializeViews(ExercisesBean object, final ViewHolder holder, final int position) {

        final ExercisesBean bean = object;
        if (bean != null) {
            holder.subject.setText(bean.subject);
            holder.tv_a.setText(bean.a);
            holder.tv_b.setText(bean.b);
            holder.tv_c.setText(bean.c);
            holder.tv_d.setText(bean.d);
        }

        if (!selectedPosition.contains("" + position)) {
            holder.iv_a.setImageResource(R.drawable.exercises_a);
            holder.iv_b.setImageResource(R.drawable.exercises_b);
            holder.iv_c.setImageResource(R.drawable.exercises_c);
            holder.iv_d.setImageResource(R.drawable.exercises_d);
            AnalysisUtils.setABCDEnable(true, holder.iv_a, holder.iv_b, holder.iv_c, holder.iv_d);
        } else {
            AnalysisUtils.setABCDEnable(true, holder.iv_a, holder.iv_b, holder.iv_c, holder.iv_d);
            switch (bean.select) {
                case 0:
                    //用户所选项是正确的
                    if (bean.answer == 1) {
                        holder.iv_a.setImageResource(R.drawable.exercises_right_icon);
                        holder.iv_b.setImageResource(R.drawable.exercises_b);
                        holder.iv_c.setImageResource(R.drawable.exercises_c);
                        holder.iv_d.setImageResource(R.drawable.exercises_d);
                    } else if (bean.answer == 2) {
                        holder.iv_a.setImageResource(R.drawable.exercises_a);
                        holder.iv_b.setImageResource(R.drawable.exercises_right_icon);
                        holder.iv_c.setImageResource(R.drawable.exercises_c);
                        holder.iv_d.setImageResource(R.drawable.exercises_d);
                    } else if (bean.answer == 3) {
                        holder.iv_a.setImageResource(R.drawable.exercises_a);
                        holder.iv_b.setImageResource(R.drawable.exercises_b);
                        holder.iv_c.setImageResource(R.drawable.exercises_right_icon);
                        holder.iv_d.setImageResource(R.drawable.exercises_d);
                    } else if (bean.answer == 4) {
                        holder.iv_a.setImageResource(R.drawable.exercises_a);
                        holder.iv_b.setImageResource(R.drawable.exercises_b);
                        holder.iv_c.setImageResource(R.drawable.exercises_c);
                        holder.iv_d.setImageResource(R.drawable.exercises_right_icon);
                    }
                    break;
                case 1:
                    //用户所选项A是错误
                    holder.iv_a.setImageResource(R.drawable.exercises_error_icon);
                    if (bean.answer == 2) {
                        holder.iv_b.setImageResource(R.drawable.exercises_right_icon);
                        holder.iv_c.setImageResource(R.drawable.exercises_c);
                        holder.iv_d.setImageResource(R.drawable.exercises_d);
                    } else if (bean.answer == 3) {
                        holder.iv_b.setImageResource(R.drawable.exercises_b);
                        holder.iv_c.setImageResource(R.drawable.exercises_right_icon);
                        holder.iv_d.setImageResource(R.drawable.exercises_d);
                    } else if (bean.answer == 4) {
                        holder.iv_b.setImageResource(R.drawable.exercises_b);
                        holder.iv_c.setImageResource(R.drawable.exercises_c);
                        holder.iv_d.setImageResource(R.drawable.exercises_right_icon);
                    }
                    break;
                case 2:
                    //用户所选项B是错误
                    holder.iv_b.setImageResource(R.drawable.exercises_error_icon);
                    if (bean.answer == 1) {
                        holder.iv_a.setImageResource(R.drawable.exercises_right_icon);
                        holder.iv_c.setImageResource(R.drawable.exercises_c);
                        holder.iv_d.setImageResource(R.drawable.exercises_d);
                    } else if (bean.answer == 3) {
                        holder.iv_a.setImageResource(R.drawable.exercises_a);
                        holder.iv_c.setImageResource(R.drawable.exercises_right_icon);
                        holder.iv_d.setImageResource(R.drawable.exercises_d);
                    } else if (bean.answer == 4) {
                        holder.iv_a.setImageResource(R.drawable.exercises_a);
                        holder.iv_c.setImageResource(R.drawable.exercises_c);
                        holder.iv_d.setImageResource(R.drawable.exercises_right_icon);
                    }
                    break;
                case 3:
                    //用户所选项C是错误
                    holder.iv_c.setImageResource(R.drawable.exercises_error_icon);
                    if (bean.answer == 1) {
                        holder.iv_a.setImageResource(R.drawable.exercises_right_icon);
                        holder.iv_b.setImageResource(R.drawable.exercises_b);
                        holder.iv_d.setImageResource(R.drawable.exercises_d);
                    } else if (bean.answer == 2) {
                        holder.iv_a.setImageResource(R.drawable.exercises_a);
                        holder.iv_b.setImageResource(R.drawable.exercises_right_icon);
                        holder.iv_d.setImageResource(R.drawable.exercises_d);
                    } else if (bean.answer == 4) {
                        holder.iv_a.setImageResource(R.drawable.exercises_a);
                        holder.iv_b.setImageResource(R.drawable.exercises_b);
                        holder.iv_d.setImageResource(R.drawable.exercises_right_icon);
                    }
                    break;
                case 4:
                    //用户所选项D是错误
                    holder.iv_d.setImageResource(R.drawable.exercises_error_icon);
                    if (bean.answer == 1) {
                        holder.iv_a.setImageResource(R.drawable.exercises_right_icon);
                        holder.iv_b.setImageResource(R.drawable.exercises_b);
                        holder.iv_c.setImageResource(R.drawable.exercises_c);
                    } else if (bean.answer == 2) {
                        holder.iv_a.setImageResource(R.drawable.exercises_a);
                        holder.iv_b.setImageResource(R.drawable.exercises_right_icon);
                        holder.iv_c.setImageResource(R.drawable.exercises_c);
                    } else if (bean.answer == 3) {
                        holder.iv_a.setImageResource(R.drawable.exercises_a);
                        holder.iv_b.setImageResource(R.drawable.exercises_b);
                        holder.iv_d.setImageResource(R.drawable.exercises_right_icon);
                    }
                    break;
                default:
                    break;
            }
        }

        /**
         * 当用户点击A选项的点击事件
         */
        holder.iv_a.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //判断selectedPosition中是否包含此时点击的position
                if (selectedPosition.contains("" + position)) {
                    selectedPosition.remove("" + position);
                } else {
                    selectedPosition.add(position + "");
                }
                onSelectListener.onSelectA(position, holder.iv_a, holder.iv_b, holder.iv_c, holder.iv_d);
                mItemClickListener.onItemClick(view, holder.getPosition() + 1);
            }
        });

        /**
         * 当用户点击B选项的点击事件
         */
        holder.iv_b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //判断selectedPosition中是否包含此时点击的position
                if (selectedPosition.contains("" + position)) {
                    selectedPosition.remove("" + position);
                } else {
                    selectedPosition.add(position + "");
                }
                onSelectListener.onSelectB(position, holder.iv_a, holder.iv_b, holder.iv_c, holder.iv_d);
                mItemClickListener.onItemClick(view, holder.getPosition() + 1);
            }
        });

        /**
         * 当用户点击C选项的点击事件
         */
        holder.iv_c.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //判断selectedPosition中是否包含此时点击的position
                if (selectedPosition.contains("" + position)) {
                    selectedPosition.remove("" + position);
                } else {
                    selectedPosition.add(position + "");
                }
                onSelectListener.onSelectC(position, holder.iv_a, holder.iv_b, holder.iv_c, holder.iv_d);
                mItemClickListener.onItemClick(view, holder.getPosition() + 1);
            }
        });

        /**
         * 当用户点击D选项的点击事件
         */
        holder.iv_d.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //判断selectedPosition中是否包含此时点击的position
                if (selectedPosition.contains("" + position)) {
                    selectedPosition.remove("" + position);
                } else {
                    selectedPosition.add(position + "");
                }
                onSelectListener.onSelectD(position, holder.iv_a, holder.iv_b, holder.iv_c, holder.iv_d);
                mItemClickListener.onItemClick(view, holder.getPosition() + 1);
            }
        });
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView subject, tv_a, tv_b, tv_c, tv_d;
        private ImageView iv_a, iv_b, iv_c, iv_d;
        private MyItemClickListener mListener;

        public ViewHolder(View view, MyItemClickListener myItemClickListener) {
            super(view);
            this.mListener = myItemClickListener;
            subject = (TextView) view.findViewById(R.id.tv_subject);
            iv_a = (ImageView) view.findViewById(R.id.iv_a);
            tv_a = (TextView) view.findViewById(R.id.tv_a);
            iv_b = (ImageView) view.findViewById(R.id.iv_b);
            tv_b = (TextView) view.findViewById(R.id.tv_b);
            iv_c = (ImageView) view.findViewById(R.id.iv_c);
            tv_c = (TextView) view.findViewById(R.id.tv_c);
            iv_d = (ImageView) view.findViewById(R.id.iv_d);
            tv_d = (TextView) view.findViewById(R.id.tv_d);

        }
    }

    public interface MyItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnSelectListener {
        void onSelectA(int position, ImageView iv_a, ImageView iv_b, ImageView iv_c, ImageView iv_d);

        void onSelectB(int position, ImageView iv_a, ImageView iv_b, ImageView iv_c, ImageView iv_d);

        void onSelectC(int position, ImageView iv_a, ImageView iv_b, ImageView iv_c, ImageView iv_d);

        void onSelectD(int position, ImageView iv_a, ImageView iv_b, ImageView iv_c, ImageView iv_d);
    }
}