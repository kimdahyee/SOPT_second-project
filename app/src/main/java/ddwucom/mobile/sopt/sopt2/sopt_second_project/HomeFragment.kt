package ddwucom.mobile.sopt.sopt2.sopt_second_project


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var instaAdapter: InstaAdapter
    val datas : MutableList<InstaData> = mutableListOf<InstaData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter = InstaAdapter(view.context)
        rv_home.adapter = instaAdapter
        //recyclerView의 어댑터를 instaAdapter로 지정
        loadDatas()
        //데이터를 임의로 생성하고 어댑터에 전달해주겠습니다!

        val itemDecoration = InstaItemDecoration(0)
        rv_home.addItemDecoration(itemDecoration)
    }

    private fun loadDatas() {
        datas.apply {
            add(InstaData(
                userName = "김다혜",
                img_profile = "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F99D8E6495DF3A01901",
                img_content = "https://post-phinf.pstatic.net/MjAxOTA0MjhfMjQ0/MDAxNTU2NDA1MjgwNDE4.b5wR6PVmc7YVDjSgZ7AcqmTHGSVgwtIm5k7WoGxsXkwg.Na1O6RgaXjlBGGDAwZFpTEdQp9Pu67ye9H3o_699jTEg.JPEG/%EC%97%BD%EB%96%A1%2B%EB%BF%8C%EB%A7%81%ED%81%B43.jpg?type=w1200"
            ))

            add(InstaData(
                userName = "나는 오늘도",
                img_profile = "https://snaptime.edaily.co.kr/wp-content/uploads/2019/10/KakaoTalk_20191023_171809807-561x700.jpg",
                img_content = "https://scontent-ssn1-1.xx.fbcdn.net/v/t1.0-9/67089394_2605642009497930_18640295503593472_n.png?_nc_cat=105&_nc_sid=8024bb&_nc_ohc=YnuBZGHuvFcAX9yHK-B&_nc_ht=scontent-ssn1-1.xx&oh=192007a5d446236df1a0dd2f1bf4ea59&oe=5ED4D639"
            ))

            add(InstaData(
                userName = "배가 고프다",
                img_profile = "https://pds.joins.com/news/component/htmlphoto_mmdata/201911/25/dded1378-9a3e-4fff-988d-d27a0bfafdd9.jpg",
                img_content = "https://post-phinf.pstatic.net/MjAxNzA1MjZfMjAy/MDAxNDk1ODA5Nzc4MjE0.a65LYjMRInIAi-eqwUPg-icvIDn0XD98H1fF-hkWfsMg.ozT2WyErzvX-CHw_vpDUgpcb2vtgSkDkokhnDa5sB7gg.JPEG/P20170421_192921584_A1C2E309-ECCC-4DC0-8815-98DEDC8C0A3D.JPG?type=w1200"
            ))

            add(InstaData(
                userName = "오늘은 뭐 먹고",
                img_profile = "https://i.pinimg.com/564x/97/51/14/9751144e63d30400fcf8a11b67ffadbb.jpg",
                img_content = "https://media.vingle.net/images/ca_l/er22drfqus.jpg"
            ))

            add(InstaData(
                userName = "내일은 뭐 먹지",
                img_profile = "https://www.the-pr.co.kr/news/photo/201910/43611_66339_2127.jpg",
                img_content = "https://t1.daumcdn.net/liveboard/mango/5213943ed9c14f3393d382f498186fc4.JPG"
            ))
        }
        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }
}
