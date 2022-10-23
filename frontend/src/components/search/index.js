import styles from './style.module.css';
import Loading from './loading'

function search() {

    return (
        <div className={styles.container}>

            <div className = {styles.text_section}>
                <div className = {styles.intro}>
                    <p>Hi, </p>
                </div>
                <div className = {styles.intro_text}>
                    <p> My name is Robert Knowles and welcome to my website!</p>
                </div>
                <hr />
            </div>
            <div className = {styles.replace}>
                <Loading />
            </div>

        </div>




    )
}

export default search;