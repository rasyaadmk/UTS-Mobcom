package com.example.utsmobcomtutor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.utsmobcomtutor.Modul.Matkul
import com.example.utsmobcomtutor.Modul.ModelRepo
import com.example.utsmobcomtutor.ui.theme.UTSMobcomTutorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                UTSMobcom()
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UTSMobcom() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF1B1B1B)
    ) {
        Column {
            TopAppBar(
                title = { Text(
                    text = "Daftar Mata Kuliah",
                    color = Color.White,
                    fontWeight = FontWeight.Bold) },
                modifier = Modifier.fillMaxWidth(),
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF5e5e5e)
                )
            )
            MataKuliah(matkul = ModelRepo.matkul)
        }
    }
}

@Composable
fun MataKuliah(matkul : List<Matkul>){
    LazyColumn(){
        items(matkul.size){
            Cards(
                matkul = matkul[it],
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun Cards(matkul: Matkul, modifier: Modifier = Modifier) {
    Card(modifier = modifier, colors = CardDefaults.cardColors(
        containerColor = Color(0xFF3D3D3D),
    )) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
                .sizeIn(minHeight = 64.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(id = matkul.matkul),
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 17.sp
                )
                Text(
                    text = stringResource(id = matkul.sks) + " SKS",
                    modifier = Modifier.padding(8.dp),
                    color = Color.White,
                )
            }
            Box(
                modifier = Modifier
                    .sizeIn(minWidth = 64.dp)
                    .padding(8.dp),
            ) {
                Image(
                    painter = painterResource(id = matkul.image),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.size(64.dp)
                )
            }}
    }
}

@Preview
@Composable
fun AppPreview(){
    UTSMobcom()
}