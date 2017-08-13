package thesis.eng.reviewer.helper


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import java.util.*

abstract class TabbedFragment : Fragment(), ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {
    var rootView: View? = null
        private set
    private var unbinder: Unbinder? = null
    private var pocketViewPagerAdapter: PocketViewPagerAdapter? = null
    private var titleList: MutableList<String>? = ArrayList()
    private var fragmentList: MutableList<Fragment>? = ArrayList()
    fun addPage(title: String, fragment: Fragment) {
        titleList!!.add(title)
        fragmentList!!.add(fragment)
    }

    protected abstract fun initLayoutRes(): Any
    protected abstract fun initViewPager(): ViewPager
    protected abstract fun initTabLayout(): TabLayout
    protected abstract fun initPages()
    protected abstract fun initPageTransformer(): ViewPager.PageTransformer
    protected abstract fun initComponents()
    protected abstract fun initServices()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(Integer.parseInt(initLayoutRes().toString()), container, false)
        unbinder = ButterKnife.bind(this, rootView!!)
        initComponents()
        initPages()
        pocketViewPagerAdapter = PocketViewPagerAdapter(childFragmentManager)
        initViewPager().setAdapter(pocketViewPagerAdapter)
        initTabLayout().setupWithViewPager(initViewPager())
        initViewPager().setPageTransformer(true, initPageTransformer())
        initViewPager().addOnPageChangeListener(this)
        initServices()
        return rootView
    }

    override fun onDestroyView() {
        pocketViewPagerAdapter = null
        titleList!!.clear()
        titleList = null
        fragmentList!!.clear()
        fragmentList = null
        unbinder!!.unbind()
        unbinder = null
        super.onDestroyView()
    }

    override fun onTabSelected(tab: TabLayout.Tab) {

    }

    override fun onTabUnselected(tab: TabLayout.Tab) {

    }

    override fun onTabReselected(tab: TabLayout.Tab) {}
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    override fun onPageSelected(position: Int) {}
    override fun onPageScrollStateChanged(state: Int) {}

    private inner class PocketViewPagerAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            var x = 0
            for (fragment in fragmentList!!) {
                if (x == position) return fragment
                x++
            }
            return null
        }

        override fun getCount(): Int {
            return titleList!!.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            var x = 0
            for (title in titleList!!) {
                if (x == position) return title
                x++
            }
            return null
        }

    }
}