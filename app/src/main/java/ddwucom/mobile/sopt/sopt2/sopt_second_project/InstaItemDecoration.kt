package ddwucom.mobile.sopt.sopt2.sopt_second_project

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class InstaItemDecoration (context : Context, padding : Int = 20): RecyclerView.ItemDecoration() {

    private val padding_size : Int

    init {
        padding_size = dpToPx(context, padding)
    }

    private  fun dpToPx(context: Context, dp : Int) : Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics).toInt()
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.getChildAdapterPosition(view) != state.itemCount -1) {
            outRect.bottom = padding_size
        }
    }

}