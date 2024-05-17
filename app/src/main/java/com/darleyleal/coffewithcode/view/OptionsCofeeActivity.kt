package com.darleyleal.coffewithcode.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.darleyleal.coffewithcode.R
import com.darleyleal.coffewithcode.databinding.ActivityOptionsCofeeBinding
import com.darleyleal.coffewithcode.viewmodel.CoffeeViewModel

class OptionsCofeeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOptionsCofeeBinding
    private val viewModel = CoffeeViewModel()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityOptionsCofeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.checkMocca.setOnClickListener {
            if (binding.checkMocca.isChecked) {
                binding.editQuantidadeMocca.setText("1")
            } else {
                binding.editQuantidadeMocca.setText("0")
            }
        }
        binding.checkLatte.setOnClickListener {
            if (binding.checkLatte.isChecked) {
                binding.editQuantidadeLatte.setText("1")
            } else {
                binding.editQuantidadeLatte.setText("0")
            }
        }
        binding.checkIced.setOnClickListener {
            if (binding.checkIced.isChecked) {
                binding.editQuantidadeIced.setText("1")
            } else {
                binding.editQuantidadeIced.setText("0")
            }
        }
        binding.checkCoado.setOnClickListener {
            if (binding.checkCoado.isChecked) {
                binding.editQuantidadeCoado.setText("1")
            } else {
                binding.editQuantidadeCoado.setText("0")
            }
        }
        binding.buttonPedir.setOnClickListener {

            val quantidadeMocca = binding.editQuantidadeMocca.text.toString()
            val quantidadeLatte = binding.editQuantidadeLatte.text.toString()
            val quantidadeIced = binding.editQuantidadeIced.text.toString()
            val quantidadeCoado = binding.editQuantidadeCoado.text.toString()

            if (binding.editQuantidadeMocca.text.toString() != "0") {
                binding.textPrecoMocca.text = viewModel.calcularValorMocca(quantidadeMocca.toInt())
            }
            if (binding.editQuantidadeLatte.text.toString() != "0") {
                binding.textPrecoLatte.text = viewModel.calcularValorLatte(quantidadeLatte.toInt())
            }
            if (binding.editQuantidadeIced.text.toString() != "0") {
                binding.textPrecoIced.text = viewModel.calcularValorIced(quantidadeIced.toInt())
            }
            if (binding.editQuantidadeCoado.text.toString() != "0") {
                binding.textPrecoCoado.text = viewModel.calcularValorCoado(quantidadeCoado.toInt())
            }

            val resultado = viewModel.calcularValorTotal(
                quantidadeMocca.toInt(), quantidadeLatte.toInt(),
                quantidadeIced.toInt(), quantidadeCoado.toInt()
            )

            binding.textTotal.text = "Total a pagar: R$ $resultado"
        }

        binding.buttonLimparCampos.setOnClickListener {
            limparTodosOsCamposDeTextoECheckbox()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun limparTodosOsCamposDeTextoECheckbox() {
        binding.editQuantidadeIced.setText("0")
        binding.editQuantidadeCoado.setText("0")
        binding.editQuantidadeMocca.setText("0")
        binding.editQuantidadeLatte.setText("0")

        binding.checkIced.isChecked = false
        binding.checkLatte.isChecked = false
        binding.checkMocca.isChecked = false
        binding.checkCoado.isChecked = false

        binding.textTotal.text = "Total:"
    }
}