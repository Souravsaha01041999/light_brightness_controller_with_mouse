VERSION 5.00
Object = "{648A5603-2C6E-101B-82B6-000000000014}#1.1#0"; "MSComm32.ocx"
Begin VB.Form Form1 
   Caption         =   "Form1"
   ClientHeight    =   4050
   ClientLeft      =   6120
   ClientTop       =   3330
   ClientWidth     =   12120
   LinkTopic       =   "Form1"
   ScaleHeight     =   4050
   ScaleWidth      =   12120
   Begin MSCommLib.MSComm MSComm1 
      Left            =   2640
      Top             =   2400
      _ExtentX        =   1005
      _ExtentY        =   1005
      _Version        =   393216
      DTREnable       =   -1  'True
   End
   Begin VB.Timer Timer1 
      Interval        =   500
      Left            =   6000
      Top             =   2160
   End
End
Attribute VB_Name = "Form1"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Dim s As String, temp As String

Private Sub Form_Load()
MSComm1.CommPort = 8
MSComm1.PortOpen = True
temp = ""
End Sub

Private Sub Form_Unload(Cancel As Integer)
MSComm1.PortOpen = False
End Sub

Private Sub Timer1_Timer()
Open "C:\Users\USER\Desktop\mouse_light_bright\data.txt" For Input As #1
Input #1, s
Close #1

If temp <> s Then
temp = s
MSComm1.Output = temp

Open "C:\Users\USER\Desktop\mouse_light_bright\data.txt" For Output As #1
Write #1, "s"
Close #1
temp = "s"

End If

End Sub
