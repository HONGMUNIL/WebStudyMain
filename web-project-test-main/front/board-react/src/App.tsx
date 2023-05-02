import React from 'react';
import './App.css';
import { Container, Grid, } from '@mui/material'
import MainHeader from './Views/Main/MainHeader/intex';
import MainMenus from './Views/Main/MainMenus';

function App() {
  return (
    <>
    <Container fixed>
      <MainHeader />
      <Grid container>
        <Grid item xs={2.5} >
            <MainMenus />
        </Grid>
      </Grid> 
    </Container>
    </>
  );
}

export default App;
