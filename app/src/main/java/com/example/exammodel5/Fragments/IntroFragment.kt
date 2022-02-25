package com.example.exammodel5.Fragments



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.exammodel5.R
import com.example.exammodel5.model.Intro


const val KEY: String = "KEY"

class IntroFragment : Fragment() {

    private lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        rootView = inflater.inflate(R.layout.fragment_intro, container, false)

        if (arguments != null) {
            val introModel = arguments?.getSerializable(KEY) as Intro
            rootView.findViewById<ImageView>(R.id.image_view).setImageResource(introModel.image)
            rootView.findViewById<TextView>(R.id.text_view_title).text = introModel.title
            rootView.findViewById<TextView>(R.id.text_view_desc).text = introModel.desc
        }

        return rootView
    }

    companion object {
        fun getInstance(introModel: Intro): IntroFragment {
            return IntroFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY, introModel)
                }
            }
        }
    }
}
