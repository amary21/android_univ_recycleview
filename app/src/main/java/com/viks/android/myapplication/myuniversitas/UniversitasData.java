package com.viks.android.myapplication.myuniversitas;

import java.util.ArrayList;

public class UniversitasData {
    public static String[][] data = new String[][]{
            {"Universitas Gajah Mada", "Yogyakarta", "https://upload.wikimedia.org/wikipedia/id/2/29/Logo_Universitas_Gadjah_Mada.png","https://www.ugm.ac.id/","UGM","19 Desember 1949","Sleman, Ypgyakrta",
                    "Universitas Gajah Mada atau biasa disingkat UGM. Kampus UGM terletak di Yogyakarta dan sudah didirikan sejak tahun 1949. UGM memang konsisten menempati posisi 1 daftar universitas terbaik di Indonesia. Dengan statusnya sebagai PTN.",
                    "https://img.ayokuliah.id/uploads/2015/09/Universitas-Gadjah-Mada.jpg"},
            {"Institut Teknologi Bandung", "Bandung", "https://upload.wikimedia.org/wikipedia/id/9/95/Logo_Institut_Teknologi_Bandung.png","https://www.itb.ac.id/","ITB","02 Maret 1959","Bandung, Jawa Barat",
                    "ITB, singkatan dari Institut Teknologi Bandung. PTN di Bandung ini menjadi institut terbaik di Indonesia yang bergerak di bidang pengembangan teknik dan sains. ITB didirikan sejak tahun 1959 dan mampu mempertahankan kualitas sebagai salah satu yang termasuk daftar PTN terbaik di Indonesia.",
                    "https://img.ayokuliah.id/uploads/2016/02/image_002001.jpg"},
            {"Institut Pertanian Bogor", "Bogor", "https://upload.wikimedia.org/wikipedia/id/thumb/c/cb/Logo_IPB.svg/1024px-Logo_IPB.svg.png","https://ipb.ac.id/","IPB","01 September","Bogor, Jawa Barat",
                    "Institut Pembangunan Bogor adalah perguruan tinggi berbentuk institut yang berada di provinsi Jawa Barat, tepatnya di kota Bogor. IPB lebih berfokus di bidang pertanian, meski banyak juga jurusan non-agragris. IPB konsisten masuk dalam daftar universitas terbaik di Indonesia di peringkat 10 besar.",
                    "https://img.ayokuliah.id/uploads/2016/02/image_002003.jpg"},
            {"Universitas Indonesia", "Depok", "https://upload.wikimedia.org/wikipedia/id/9/95/Makara_UI.png","http://www.ui.ac.id/","UI","1849","Depok, Jawa Barat",
                    "Universitas Indonesia atau UI, Letaknya berada di perbatasn kota Depok dan Jakarta, namun sering dianggap sebagai universitas di Jakarta. Kampus negeri di Jakarta ini pertama didirikan di tahun 1849. UI juga pernah beberapa kali menempati peringkat 1 list universitas terfavorit di Indonesia dan termasuk salah satu universitas terbesar di Indonesia.",
                    "https://img.ayokuliah.id/uploads/2015/09/Universitas-Indonesia.jpg"},
            {"Universitas Bina Nusantara", "Jakarta Barat", "https://image.psikolif.com/wp-content/uploads/2018/10/Logo-Binus-University-Universitas-Bina-Nusantara-Original-PNG.png","https://binus.ac.id/","BINUS","01 Juli 1981","Jakarta Barat, DKI Jakarta",
                    "Universitas Bina Nusantara juga dikenal dengan Binus University adalah salah satu universitas swasta Indonesia yang berlokasi di Jakarta, Indonesia. Universitas ini bernaung di bawah lembaga pendidikan Bina Nusantara",
                    "http://binus.ac.id/wp-content/uploads/2011/08/jwc-campus.jpg"},
            {"Universitas Diponegoro", "Semarang", "https://upload.wikimedia.org/wikipedia/id/2/2d/Undip.png","https://www.undip.ac.id/language/id/","UNDIP","09 Januari 1957","Semarang, Jawa Tengah",
                    "UNDIP atau Universitas Diponegoro terletak di kota Semarang, dan layak dianggap sebagai universitas terbaik di Jawa Tengah. Letaknya yang cukup strategis serta pilihan jurusan yang bervariasi membuat UNDIP jadi salah satu rekomendasi tempat kuliah terbaik di Indonesia yang enak.",
                    "https://img.ayokuliah.id/uploads/2016/02/image_001008.jpg"},
            {"Universitas Teknologi Yogyakarta", "Yogyakarta", "http://kadowisudaku.com/wp-content/uploads/2016/11/Logo-Universitas-Teknologi-Yogyakarta-UTY.png","http://uty.ac.id/","UTY","23 Oktober 2002","Sleman, Yogyakarta",
                    "Universitas Teknologi Yogyakarta atau biasa disingkat UTY adalah salah satu perguruan tinggi swasta terbaik yang berbentuk universitas di Provinsi Daerah Istimewa Yogyakarta (DIY), Universitas ini diselenggarakan oleh Yayasan \"Dharma Bhakti IPTEK\", Bediri pada 23 Oktober 2002 dengan penggabungan tiga perguruan tinggi melalui Surat Keterangan Menteri Pendidikan Nasional RI No 237/D/0/2002 tertanggal 23 Oktober 2002.",
                    "https://www.jogjaland.net/wp-content/uploads/2014/04/UTY.jpg"}
    };

    public static ArrayList<Universitas> getListData(){
        Universitas univ = null;
        ArrayList<Universitas> list = new ArrayList<>();
        for (String[] aData : data) {
            univ = new Universitas();
            univ.setNama(aData[0]);
            univ.setDaerah(aData[1]);
            univ.setLogo(aData[2]);
            univ.setOfficial(aData[3]);
            univ.setSingkatan(aData[4]);
            univ.setDidirikan(aData[5]);
            univ.setAlamat(aData[6]);
            univ.setSinopsis(aData[7]);
            univ.setTaman(aData[8]);

            list.add(univ);
        }

        return list;
    }
}
