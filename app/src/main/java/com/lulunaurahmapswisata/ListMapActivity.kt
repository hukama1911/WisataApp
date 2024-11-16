package com.lulunaurahmapswisata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lulunaurahmapswisata.Adapter.adapterWisata
import com.lulunaurahmapswisata.model.ModelWisata

class ListMapActivity : AppCompatActivity() {
    private lateinit var RecyclerViewMenu: RecyclerView
    private lateinit var AdapterMenu: adapterWisata

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_map)

        val menuIcons = listOf(
            ModelWisata(
                R.drawable.jamgadang,
                "Jam gadang Bukittinggi",
                "Bukittinggi, Sumatera Barat",
                "Jam Gadang adalah menara jam ikon Kota Bukittinggi Sumatera Barat Indonesia.",
                -0.3049441760037679, 100.36948795756079
            ),

            ModelWisata(
                R.drawable.borobudur,
                "Candi Borobudur",
                "Magelang, Jawa Tengah",
                "Dibangun dari abad ke-9, situs ini terkenal sebagai candi Buddha terbesar di dunia",
                -7.604879709882314, 110.2035859416411
            ),
            ModelWisata(
                R.drawable.rajaampat,
                "Raja Ampat",
                "Papua Barat",
                "Kepulauan Raja Ampat adalah gugusan kepulauan yang berlokasi di barat bagian Semenanjung Kepala Burung Pulau Papua. Secara administrasi, gugusan ini berada di bawah Kabupaten Raja Ampat dan Kota Sorong, Provinsi Papua Barat Daya.",
                -1.015409457948771, 130.85823999688617
            ),
            ModelWisata(
                R.drawable.danautoba,
                "Danau Toba",
                "Sumatera Utara",
                "Danau Toba adalah danau alami berukuran besar di Sumatera Utara, Indonesia yang terletak di kaldera gunung supervulkan. Danau ini memiliki panjang 100 kilometer, lebar 30 kilometer, dan kedalaman 508 meter. Danau ini terletak di tengah pulau Sumatra bagian utara dengan ketinggian permukaan sekitar 900 mete",
                2.8018526643909647, 98.77124925053705
            )
        )

        RecyclerViewMenu = findViewById(R.id.rvwisata)
        RecyclerViewMenu.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        AdapterMenu = adapterWisata(menuIcons)
        RecyclerViewMenu.adapter = AdapterMenu

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}