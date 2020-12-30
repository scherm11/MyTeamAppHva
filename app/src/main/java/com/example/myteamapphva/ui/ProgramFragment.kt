package com.example.myteamapphva.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myteamapphva.R
import com.example.myteamapphva.helper.DateFormatHelper
import com.example.myteamapphva.models.Game
import kotlinx.android.synthetic.main.fragment_program.*

class ProgramFragment : Fragment() {
    private lateinit var programAdapter: ProgramAdapter
    private val program = arrayListOf<Game>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_program, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        // initialize some dummy data for checking if data gets displayed in the right manner

        val game = Game()
        val game1 = Game()
        game.id = 1000
        game.homeTeam = "AJAX"
        game.awayTeam = "FEYENOORD"

        val currentTime = DateFormatHelper().getCurrentDateTime()
        val currentTimeInString = DateFormatHelper().formatToString(currentTime, "dd-MM-yyyy")
        game.date = currentTimeInString

        game1.id = 1001
        game1.homeTeam = "PSV"
        game1.awayTeam = "AZ"

        game1.date = currentTimeInString

        program.add(game)
        program.add(game1)

        programAdapter = ProgramAdapter(program)
        rvProgram.layoutManager = LinearLayoutManager(context)
        rvProgram.adapter = programAdapter
    }

}