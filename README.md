
# SOPT_second-project

SOPT 2차 세미나 과제

## [ 기본 과제 1 ] Bottom Navigation, ViewPager, RecyclerView 이용해서 직접 실습하기

**Bottom Navigation**
: 하단 네비게이션 뷰, 하단에 있는 아이콘 클릭을 통해 이동

**ViewPager**
: 데이터를 페이지 단위로 표시하고 화면을 쓸어 넘기는 동작인 swipe를 통해 페이지 전환을 할 수 있는 컨테이너, 자체적으로 그리는 기능이 있지 않고 위젯을 배치하여 viewPager의 각 페이지를 구성

1.  라이브러리 등록 - build.gradle(app) 수정

	제일 상단에 아래 코드 추가

	    apply plugin: "kotlin-kapt"

	dependencies 안에 아래 코드 추가
	
	    implementation 'androidx.recyclerview:recyclerview:1.1.0'  
	    //recyclerview를 다루기 위한 라이브러리  
	    implementation "com.google.android.material:material:1.2.0-alpha05"  
	    //BottomNavigation 등 구글에서 제공하는 디자인 라이브러리  
	    implementation "com.github.bumptech.glide:glide:4.10.0"  
	    kapt "com.github.bumptech.glide:compiler:4.10.0"  
	    //이미지 url을 로딩시켜 뷰에 연결해주는 라이브러리  
	    implementation 'de.hdodenhof:circleimageview:3.1.0'  
	    //동그란 이미지 커스텀 뷰 라이브러리

2.  custom UI 적용

	A. custom UI 적용 - styles.xml 수정

	    <!-- 상단 바 기본 UI를 없애고 커스텀 UI 적용하는 부분 -->  
	    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">  
	        <!-- Customize your theme here. -->  
	    </style>
	    
	 B. 기본 색상 설정 - colors.xml 수정

	    <resources>  
		    <!-- 기본 색상 설정 -->
		    <color name="colorPrimary">#073392</color>  
		    <color name="colorPrimaryDark">#08338d</color>  
		    <color name="colorAccent">#ff0000</color>  
		    <color name="white">#ffffff</color>  
		</resources>

	C. custom 상단 바 설정 -  activity_main.xml 수정
	
		<!-- custom 상단 바를 넣은 부분, ConstraintLayout의 자식 -->
		<com.google.android.material.appbar.AppBarLayout  
			android:id="@+id/appBarLayout"  
			android:layout_width="match_parent"  
			android:layout_height="wrap_content"  
			app:layout_constraintTop_toTopOf="parent">  
		  
		   <androidx.appcompat.widget.Toolbar  
				android:id="@+id/main_toolbar"  
				android:layout_width="match_parent"  
				android:layout_height="wrap_content"  
				android:background="@color/colorPrimary">  
		  
		        <TextView  
					android:layout_width="wrap_content"  
					android:layout_height="wrap_content"  
					android:gravity="center"  
					android:maxEms="15"  
					android:text="@string/app_name"  
					android:textColor="@color/white"  
					android:textSize="18sp"  
					android:textStyle="bold" />  
					
			</androidx.appcompat.widget.Toolbar>  
		</com.google.android.material.appbar.AppBarLayout>

	D. Bottom Navigation / ViewPager layout 설정 -  activity_main.xml 수정

	    <com.google.android.material.bottomnavigation.BottomNavigationView  
		  android:id="@+id/bottomNavigationView"  
		  android:layout_width="0dp"  
		  android:layout_height="60dp"  
		  android:background="@color/colorPrimary"  
		  <!-- background 속성을 이용하여 아까 설정한 색 적용 -->
		  app:layout_constraintBottom_toBottomOf="parent"  
		  app:layout_constraintEnd_toEndOf="parent"  
		  app:layout_constraintStart_toStartOf="parent"  /> 
		  
		<androidx.viewpager.widget.ViewPager  
		  android:id="@+id/main_viewPager"  
		  android:layout_width="match_parent"  
		  android:layout_height="0dp"  
		  app:layout_constraintBottom_toTopOf="@+id/bottomNavigationView"  
		  app:layout_constraintEnd_toEndOf="parent"  
		  app:layout_constraintHorizontal_bias="0.0"  
		  app:layout_constraintStart_toStartOf="parent"  
		  app:layout_constraintTop_toBottomOf="@+id/appBarLayout"  
		  app:layout_constraintVertical_bias="0.344" />

	<img width="230" src="https://user-images.githubusercontent.com/63586451/82624941-cf5aae80-9c1e-11ea-9e3b-01224e5f7a94.jpg" /> 

	**여기까지 세팅 완료! 이제 하단 네비게이션 메뉴를 만들어 보아요**
	
	E. 하단 네비게이션 메뉴 생성 
	- res - new - android resource directory 선택해서 menu directory 생성
	- 만든 menu folder - new - menu resource file 선택해서 파일 생성한 후 메뉴 설정
     
	     [navigation.xml]

		   <menu xmlns:android="http://schemas.android.com/apk/res/android"  
			  xmlns:app="http://schemas.android.com/apk/res-auto">  
			  <item android:id="@+id/menu_home"  
				  android:icon="@drawable/ic_home_white"  
				  android:title="Home"/>  
			  <item android:id="@+id/menu_book"  
				  android:icon="@drawable/ic_book_white"  
				  android:title="Book"/>  
			  <item android:id="@+id/menu_person"  
				  android:icon="@drawable/ic_person_white"  
				  android:title="MyPage"/> 
		   </menu>
		  
	F.  vector asset 생성
	- drawable - new - vector asset 선택해서 원하는 아이콘과 이름 설정 후 Finish 
	
	G.  메뉴가 클릭 되었을 때 / 되지 않았을 때의 색상 설정
	- res - new - android resource directory 선택해서 color directory 생성
	- 만든 color folder - new - color resource file 선택해서 파일 생성한 후 색상 설정
	
		   <selector xmlns:android="http://schemas.android.com/apk/res/android">  
			   <item android:color="@color/white" android:state_checked="true" />  
			   <item android:color="#d9d9d9" android:state_checked="false" /> 
		   </selector>
		  
	H.  생성한 메뉴 및 아이콘과 텍스트 색상 적용 -  activity_main.xml 수정
	
	    <com.google.android.material.bottomnavigation.BottomNavigationView  
			  android:id="@+id/bottomNavigationView"  
			  android:layout_width="0dp"  
			  android:layout_height="60dp"  
			  android:background="@color/colorPrimary"  
			  <!-- background 속성을 이용하여 아까 설정한 색 적용 -->
			  app:layout_constraintBottom_toBottomOf="parent"  
			  app:layout_constraintEnd_toEndOf="parent"  
			  app:layout_constraintStart_toStartOf="parent"  
			  app:itemIconTint="@color/bottom_selector"  
			  app:itemTextColor="@color/bottom_selector"  
			  app:menu="@menu/navigation" />  
			  <!-- 메뉴 및 아이콘 텍스트의 색깔 적용 -->  
			  
3.  Fragment 생성

	**Fragment란?** Activity 내에서 화면 UI 일부를 나타내고 여러 개의 fragment를 조합하여 Activity가 출력하는 한 화면의 UI 표현 가능,  Activity 실행 중에도 화면에 동적으로 추가되거나 다른 fragment로 교체 가능
	
	- new - Fragment - Fragment(Blank) 선택해서 이름 설정하고 include 선택지 선택 취소한 후 Finish
	
		[HomeFragment.kt] 
		
		   class HomeFragment : Fragment() {  
		  
			    override fun onCreateView(  
			        inflater: LayoutInflater, container: ViewGroup?,  
			        savedInstanceState: Bundle?  
			    ): View? {  
			        // Inflate the layout for this fragment  
			  return inflater.inflate(R.layout.fragment_home, container, false)  
			    }  
			}
			
		[LibraryFragment.kt] 
		
		   class LibraryFragment : Fragment() {  
		  
			    override fun onCreateView(  
			        inflater: LayoutInflater, container: ViewGroup?,  
			        savedInstanceState: Bundle?  
			    ): View? {  
			        // Inflate the layout for this fragment  
			  return inflater.inflate(R.layout.fragment_library, container, false)  
			    }  
			}

		[MypageFragment.kt] 
			
			   class MypageFragment : Fragment() {  
			  
				    override fun onCreateView(  
				        inflater: LayoutInflater, container: ViewGroup?,  
				        savedInstanceState: Bundle?  
				    ): View? {  
				        // Inflate the layout for this fragment  
				  return inflater.inflate(R.layout.fragment_mypage, container, false)  
				    }  
				}
		---
		[fragment_home.xml] 

			<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"  
			  xmlns:tools="http://schemas.android.com/tools"  
			  android:layout_width="match_parent"  
			  android:layout_height="match_parent"  
			  tools:context=".HomeFragment">  
			  
			    <!-- TODO: Update blank fragment layout -->  
			  <TextView  
			  android:layout_width="match_parent"  
			  android:layout_height="match_parent"  
			  android:text="홈 화면입니다." />  
			</FrameLayout>

		[fragment_library.xml] 

					<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"  
					  xmlns:tools="http://schemas.android.com/tools"  
					  android:layout_width="match_parent"  
					  android:layout_height="match_parent"  
					  tools:context=".LibraryFragment">  
					  
					    <!-- TODO: Update blank fragment layout -->  
					  <TextView  
					  android:layout_width="match_parent"  
					  android:layout_height="match_parent"  
					  android:text="서재 화면입니다." />  
					</FrameLayout>

		[fragment_mypage.xml] 

					<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"  
					  xmlns:tools="http://schemas.android.com/tools"  
					  android:layout_width="match_parent"  
					  android:layout_height="match_parent"  
					  tools:context=".MypageFragment">  
					  
					    <!-- TODO: Update blank fragment layout -->  
					  <TextView  
					  android:layout_width="match_parent"  
					  android:layout_height="match_parent"  
					  android:text="마이페이지 화면입니다." />  
					</FrameLayout>
		
		***각 페이지에 해당하는 layout을  activity 하나가 아닌 여러  fragment로 분리하여 관리***
		
		***이제  Adapter를 사용해서  ViewPager와   Fragment를 연결 !!***

4.  ViewPager에 Fragment 연결

	A.  Adapter 생성

	**Adapter란?** 보여지는 view와 그 view에 보여줄 data를 연결하는 일종의 bridge
	
	- new - Kotlin File/Class 선택해서 Adapter class 생성 
	
		[MainPagerAdapter.kt]
   
		  class MainPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){ 
		  
			  override fun getItem(position: Int): Fragment {  
		            return when(position) {  
		                0 -> HomeFragment()  //index가 0일때
		                1 -> LibraryFragment()  
		                else -> MypageFragment()  
		            }  
		      }  
		      
		        override fun getCount() = 3  
		  }

	B.  ViewPager에 Adapter 적용 - MainActivity.kt 수정

		 class MainActivity : AppCompatActivity() {  
	  
		    override fun onCreate(savedInstanceState: Bundle?) {  
		        super.onCreate(savedInstanceState)  
		        setContentView(R.layout.activity_main)  
		  
		        main_viewPager.adapter = MainPagerAdapter(supportFragmentManager)  
		        main_viewPager.offscreenPageLimit = 2
		        //현재 페이지가 2라면 | 0 1 2 3 4 까지 잡아놓아, 앞 뒤로 2 페이지씩
		    }
		 }

5.  Bottom Navigation의 메뉴 클릭 시 해당하는 fragment가 호출되어 화면에 표시되도록 설정 - MainActivity.kt 수정

		 main_viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {  
		 //ViewPager의 이동-> -> 하단 탭의 체크 상태 변화
			   override fun onPageScrollStateChanged(state: Int) {  
			   }  
				  
			   override fun onPageScrolled( 
				   position: Int,  
				   positionOffset: Float,  
				   positionOffsetPixels: Int  
			   ) {  
			   }  
				  
			   override fun onPageSelected(position: Int) {  
			       //navigation 메뉴 아이템 체크  
				  bottomNavigationView.menu.getItem(position).isChecked = true  
			  }  
		 })  
		  
		 bottomNavigationView.setOnNavigationItemSelectedListener {  
		 //하단 탭의 체크 이벤트 -> 해당하는 페이지로 이동
			  when (it.itemId) {  
			        R.id.menu_home -> main_viewPager.currentItem = 0  
				    R.id.menu_book -> main_viewPager.currentItem = 1  
				    R.id.menu_person -> main_viewPager.currentItem = 2  
			  }  
			  true  
		 }

**RecyclerView**
: RecyclerView는 사용자가 관리하는 많은 수의 데이터 집합을 개별 item 단위로 구성하여 화면에 출력하는 ViewGroup이며, 한 화면에 표시되기 힘든 많은 수의 데이터를 scroll이 가능한 list로 표시해주는 위젯


***동일한 형태를 가진 뷰 !! 틀은 같고 그 자리에 들어가는 데이터만 다르다***

1.  반복될 View 하나 생성 
	- Layout - new - layout resource file 선택해서 새로운 layout file 생성
	
		[item_insta.xml]
		
		  <?xml version="1.0" encoding="utf-8"?>  
			<androidx.constraintlayout.widget.ConstraintLayout  
			  xmlns:android="http://schemas.android.com/apk/res/android"  
			  xmlns:app="http://schemas.android.com/apk/res-auto"  
			  xmlns:tools="http://schemas.android.com/tools"  
			  android:layout_width="match_parent"  
			  android:layout_height="wrap_content"  
			  android:clipToPadding="false" >  
			  
			    <androidx.constraintlayout.widget.ConstraintLayout  
					  android:id="@+id/constraintLayout"  
					  android:layout_width="match_parent"  
					  android:layout_height="wrap_content"  
					  android:background="@color/colorPrimary"  
					  android:paddingHorizontal="24dp"  
					  android:paddingVertical="8dp"  
					  app:layout_constraintTop_toTopOf="parent" >  
			  
			        <de.hdodenhof.circleimageview.CircleImageView  
						  android:id="@+id/img_profile"  
						  android:layout_width="48dp"  
						  android:layout_height="48dp"  
						  android:src="@drawable/profile"  
						  app:layout_constraintStart_toStartOf="parent"  
						  app:layout_constraintTop_toTopOf="parent" />  
			  
			        <TextView  
						  android:id="@+id/tv_username"  
						  android:layout_width="wrap_content"  
						  android:layout_height="wrap_content"  
						  android:layout_marginStart="8dp"  
						  android:text="TextView"  
						  android:textColor="@color/white"  
						  android:textSize="16sp"  
						  android:textStyle="bold"  
						  app:layout_constraintBottom_toBottomOf="@+id/img_profile"  
						  app:layout_constraintStart_toEndOf="@+id/img_profile"  
						  app:layout_constraintTop_toTopOf="@+id/img_profile"  
						  android:layout_marginLeft="8dp" />  
			  
			        <ImageView  
						  android:id="@+id/imageView"  
						  android:layout_width="wrap_content"  
						  android:layout_height="wrap_content"  
						  app:layout_constraintBottom_toBottomOf="@+id/tv_username"  
						  app:layout_constraintEnd_toEndOf="parent"  
						  app:layout_constraintTop_toTopOf="@+id/tv_username"  
						  app:srcCompat="@drawable/ic_more"  
						  tools:ignore="VectorDrawableCompat" />  
				  </androidx.constraintlayout.widget.ConstraintLayout>  
			  
			    <ImageView  
					  android:id="@+id/img_contents"  
					  android:layout_width="0dp"  
					  android:layout_height="0dp"  
					  android:scaleType="centerCrop"  
					  app:layout_constraintEnd_toEndOf="parent"  
					  app:layout_constraintStart_toStartOf="parent"  
					  app:layout_constraintDimensionRatio="1"  
					  app:layout_constraintTop_toBottomOf="@+id/constraintLayout"  
					  app:srcCompat="@drawable/ic_launcher_background"  
					  tools:ignore="VectorDrawableCompat" />  
		    </androidx.constraintlayout.widget.ConstraintLayout>

2.  배치 방향 설정 - fragment_home.xml 수정

		<androidx.recyclerview.widget.RecyclerView  
		  android:id="@+id/rv_home"  
		  android:layout_width="match_parent"  
		  android:layout_height="wrap_content"  
		  app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"  
		  android:orientation="vertical"  
		  tools:listitem="@layout/item_insta"  
		  android:clipToPadding="false" />

    **LayoutManager**
        - LinearLayoutManager : 세로/가로 방향 배치
        - GridLayoutManager : 바둑판 형식 배치

3.  어디에 데이터를 넣을지, 어떤 데이터를 넣을지 설정

	***데이터가 있으면  Adapter가 데이터 리스트 중 하나를  ViewHolder에게 전달하고  ViewHolder는 받은 데이터를  View에 뿌려준다 !!***

	A.  데이터 형태 결정
	
	[InstaData.kt]

	    data class InstaData (  
	        val userName : String,  
	        val img_profile : String,  
	        val img_content : String  
	    )
	    
	B.  ViewHolder 생성
	
	**ViewHolder란?** 동일한 형태의 view 하나에 대한 데이터 넣을 위치 정보를 알고 있는 녀석
	
	[InstaViewHolder.kt]

		class InstaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {  
		    val tv_username = itemView.findViewById<TextView>(R.id.tv_username)  
		    val img_profile = itemView.findViewById<ImageView>(R.id.img_profile)  
		    val img_contents = itemView.findViewById<ImageView>(R.id.img_contents)  
		  
		    fun bind(instaData : InstaData) {  
		        tv_username.text = instaData.userName  
		  Glide.with(itemView).load(instaData.img_profile).into(img_profile)  
		        Glide.with(itemView).load(instaData.img_content).into(img_contents)  
		    }  
		}
	  
	C.  Adapter 생성
	
	[InstaAdapter.kt]
	
		class InstaAdapter(private val context : Context) : RecyclerView.Adapter<InstaViewHolder>() {  
		  
		    var datas : MutableList<InstaData> = mutableListOf<InstaData>()  
		  
		    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstaViewHolder {  
		        val view = LayoutInflater.from(context).inflate(R.layout.item_insta, parent, false)  
		        return InstaViewHolder(view)  
		    }  
		  
		    override fun getItemCount(): Int {  
		        return datas.size  
		  }  
		  
		    override fun onBindViewHolder(holder: InstaViewHolder, position: Int) {  
		        holder.bind(datas[position])  
		    }  
		}
	
	D. RecyclerView에 Adpater 적용 - HomeFragment.kt 수정

		class HomeFragment : Fragment() {  
		  
		    lateinit var instaAdapter: InstaAdapter  
		    lateinit var layoutManager: LinearLayoutManager  
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
		        initRcv(view)  
		        loadDatas()  
		        //데이터를 임의로 생성하고 어댑터에 전달해주겠습니다!  
		    }  
		  
		    private fun initRcv(view : View) {  
		        instaAdapter = InstaAdapter(view.context)  
		        rv_home.adapter = instaAdapter  
			    //recyclerView의 어댑터를 instaAdapter로 지정  
			    rv_home.apply {  
			    layoutManager = LinearLayoutManager(view.context)  
			            addItemDecoration(InstaItemDecoration(view.context))  
			    }  
			}  
		  
		    private fun loadDatas() {  
		        datas.apply {   
		            add(InstaData(  
		                userName = "",  
		                img_profile = "",  
		                img_content = ""  
				)) 
		    }  
		    //AndroidMenifest.xml에서 uses-permission INTERNET 설정을 해줘야만 이미지 로드 가능
		    
		    instaAdapter.datas = datas  
		    instaAdapter.notifyDataSetChanged()  
		    //데이터가 갱신되었음을 Adapter에게 알려주는 역할
		  }  
		}


**실습 결과**
<p float="left">

  <img width="230" src="https://user-images.githubusercontent.com/63586451/81278778-18dcc280-9091-11ea-887d-a4333f08037f.png">

  <img width="230" src="https://user-images.githubusercontent.com/63586451/81278841-3447cd80-9091-11ea-956e-f337f8b45d6b.png">

  <img width="230" src="https://user-images.githubusercontent.com/63586451/81278846-36119100-9091-11ea-949b-8a5e2fb7290b.png">
  
<p>
  
<p float="left">
  <img width="230" src="https://user-images.githubusercontent.com/63586451/81278849-3742be00-9091-11ea-8294-327f7af96287.png"> 

  <img width="230" src="https://user-images.githubusercontent.com/63586451/81278854-390c8180-9091-11ea-9a74-196cc7c4edc2.png">
  
<p>

## [기본 과제 2] RecyclerView의 itemDecoration, clipToPadding에 대해 공부하고 적용하기

> itemDecoration과 clipToPadding의 기능이 무엇인지 요약하기

**itemDecoration**
: itemDecoration를 통해 item 사이의 간격을 설정 할 수 있다.

**clipToPadding**
: top 혹은 bottom에 padding을 주었을 경우
`android:clipToPadding="false" `를 해줘야 scroll하면서 
설정한 padding 부분이 사라지지 않는다.

<p float="left">
  
  <img width="230" src="https://user-images.githubusercontent.com/63586451/81278857-3ad64500-9091-11ea-839d-aed727b30b40.png"> 

  <img width="230" src="https://user-images.githubusercontent.com/63586451/81278865-3ca00880-9091-11ea-88a4-b1e601394d92.png">
  
<p>
