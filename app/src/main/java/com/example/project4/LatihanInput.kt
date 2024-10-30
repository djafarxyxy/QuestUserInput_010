package com.example.project4


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier){

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var dataGender = listOf("laki-laki", "perempuan")

    var Namasy by remember { mutableStateOf("") }
    var Emailsy by remember { mutableStateOf("") }
    var Alamatsy by remember { mutableStateOf("") }
    var Noteleponsy by remember { mutableStateOf("") }
    var Gendersy by remember { mutableStateOf("") }


    Column(modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        TextField(
            value = nama,
            onValueChange = {nama = it},
            label = {
                Text(text = "Nama")
            },
            placeholder = {
                Text(text = "isi nama anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        Row (modifier = Modifier.fillMaxWidth()){
            dataGender.forEach{selectedGender ->
                Row (
                    verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = { gender = selectedGender
                        }
                    )
                    Text(text = selectedGender)

                }}
        }

        TextField(
            value = email,
            onValueChange = {email = it},
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "isi email anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text(text = "Alamat")
            },
            placeholder = {
                Text(text = "isi alamat anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        TextField(
            value = notelepon,
            onValueChange = {notelepon = it},
            label = {
                Text(text = "No Telepon")
            },
            placeholder = {
                Text(text = "isi No telepon anda") //Hint text
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            Namasy = nama
            Emailsy = email
            Alamatsy = alamat
            Noteleponsy = notelepon
            Gendersy = gender
        }) {
            Text(text = "Simpan")

        }
        
        DetailMessage(param = "Nama",  argum = Namasy)
        DetailMessage(param = "Email",  argum = Emailsy)
        DetailMessage(param = "Alamat",  argum = Alamatsy)
        DetailMessage(param = "No Telepon",  argum = Noteleponsy)
        DetailMessage(param = "Gender",  argum = Gendersy)
    }
}

@Composable
fun DetailMessage(
    param: String, argum: String
){
    Column(
        modifier = Modifier.padding(16.dp))
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            Text(text = param,
                modifier = Modifier.weight(0.8f)) // memberi ruang seberapa banyak dalam kolon/barisnya
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = argum, //kenapa argum? karena isinya akan digantikan dengan parameter argum
                modifier = Modifier.weight(2f))

        }
    }
}