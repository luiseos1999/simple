package com.example.simple.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.beagle.android.utils.loadView
import br.com.zup.beagle.android.view.ScreenRequest
import br.com.zup.beagle.android.view.custom.BeagleViewState
import br.com.zup.beagle.android.view.custom.OnStateChanged
import com.example.simple.R
import com.example.simple.constants.MENU_PATH
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        screenHome()
    }

    private fun screenHome() {
        fl_menu.removeAllViewsInLayout()
        fl_menu.loadView(this, ScreenRequest(MENU_PATH),
                object :
                        OnStateChanged {
                    override fun invoke(state: BeagleViewState) {
                        when (state) {
                            is BeagleViewState.LoadStarted -> {
                                pb_menu.visibility = View.VISIBLE
                            }
                            is BeagleViewState.LoadFinished -> {
                                pb_menu.visibility = View.GONE
                            }
                            is BeagleViewState.Error -> {
                                state.throwable.printStackTrace()
                            }
                        }
                    }

                })
    }

    companion object {
        fun newInstance() = MenuFragment()
    }


}