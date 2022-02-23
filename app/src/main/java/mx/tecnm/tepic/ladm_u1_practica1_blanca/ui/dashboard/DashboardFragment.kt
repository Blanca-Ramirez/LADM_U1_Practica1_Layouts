package mx.tecnm.tepic.ladm_u1_practica1_blanca.ui.dashboard

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_home.*
import mx.tecnm.tepic.ladm_u1_practica1_blanca.R
import mx.tecnm.tepic.ladm_u1_practica1_blanca.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    var contador = 1
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.siguiente.setOnClickListener {
            if(contador==4) contador=2
            when(contador){

                    1->{binding.comida.setText("Curry")
                val imgpikachu = R.drawable.plato
                var respika = imgpikachu

                binding.catalogo.setImageResource(respika)
                contador++}
                2->{binding.comida.setText("Sandwich")
                    val imgpikachu = R.drawable.dugtrio
                    var resdug = imgpikachu

                    binding.catalogo.setImageResource(resdug)
                    contador++}
                    3->{binding.comida.setText("Hot Cakes")
                    val imgpikachu = R.drawable.pancakes
                    var resdug = imgpikachu

                    binding.catalogo.setImageResource(resdug)
                contador=1}
            }
        }
        binding.anterior.setOnClickListener {

            if(contador==4) contador=1
            when(contador){

                3->{binding.comida.setText("Curry")
                    val imgpikachu = R.drawable.plato
                    var respika = imgpikachu

                    binding.catalogo.setImageResource(respika)
                    contador++}
                1->{binding.comida.setText("Sandwich")
                    val imgpikachu = R.drawable.dugtrio
                    var resdug = imgpikachu

                    binding.catalogo.setImageResource(resdug)
                    contador++}
                2->{binding.comida.setText("Hot Cakes")
                    val imgpikachu = R.drawable.pancakes
                    var resdug = imgpikachu

                    binding.catalogo.setImageResource(resdug)
                    contador=3}
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}